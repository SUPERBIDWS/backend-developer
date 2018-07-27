package net.superbid.blog.service;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import net.superbid.blog.controller.exception.InvalidPostDataException;
import net.superbid.blog.controller.exception.PostNotFoundException;
import net.superbid.blog.domain.Post;
import net.superbid.blog.dto.PostDTO;
import net.superbid.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service interface implementation for all Post-related operations. This implementation
 * uses PostRepository to handle persistence.
 *
 * @author renato
 */
@Service
@Transactional(readOnly = true)
@Slf4j
public class PostServiceImpl implements PostService {
    
    @Autowired
    private PostRepository postRepository;
    
    /**
     * Helper method to convert a post entity to a post DTO.
     * @param post post entity
     * @return post DTO
     */
    private PostDTO convertToDTO(Post post) {
        log.trace("Converting Post entity to DTO: " + post.toString());
        return PostDTO
                .builder()
                .id(post.getId())
                .title(post.getTitle())
                .description(post.getDescription())
                .publishedDate(post.getPublishedDate())
                .build();
    }
    
    /**
     * Helper method to convert a post DTO to a post entity.
     * @param post post DTO
     * @return post entity
     */
    private Post convertToEntity(PostDTO post) {
        log.trace("Converting Post DTO to entity: " + post.toString());
        return Post.builder()
                .id(post.getId())
                .title(post.getTitle())
                .description(post.getDescription() == null || post.getDescription().isEmpty()
                                ? post.getTitle()
                                : post.getDescription())
                .build();
    }

    @Override
    public Page<PostDTO> findAll(Pageable pageable) {
        log.trace("Listing all posts");
        return postRepository
                .findAll(pageable)
                .map(this::convertToDTO);
    }

    @Override
    public Optional<PostDTO> findById(Long postId) {
        log.trace("Searching for post id" + postId);
        if (postId == null || postId < 1L)  {
            throw new InvalidPostDataException(postId);
        }
        return Optional
                .ofNullable(postRepository.findOne(postId))
                .map(this::convertToDTO);
    }

    @Transactional
    @Override
    public PostDTO create(PostDTO post) {
        log.trace("Creating post: " + post);
        validate(post);
        post.setId(null);
        return convertToDTO(postRepository.save(convertToEntity(post)));
    }

    @Transactional
    @Override
    public PostDTO update(PostDTO post) {
        log.trace("Updating post: " + post);
        validate(post);
        if (!findById(post.getId()).isPresent()) {
            throw new PostNotFoundException(post.getId());
        }
        return convertToDTO(postRepository.save(convertToEntity(post)));
    }

    @Transactional
    @Override
    public void delete(Long postId) {
        log.trace("Deleting post with id=" + postId);
        if (!findById(postId).isPresent()) {
            throw new PostNotFoundException(postId);
        }
        postRepository.delete(postId);
    }
    
    /**
     * Validates post data in DTO used for input. Required post data
     * @param post 
     */
    private void validate(PostDTO post) {
        if (post == null || post.getTitle() == null || post.getTitle().isEmpty()) {
            throw new InvalidPostDataException(post, "title");
        }
    }
    
}
