package net.superbid.blog.service;

import java.util.Optional;
import net.superbid.blog.dto.PostDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service interface for all Post-related operations. As an interface, it defines
 * all methods available for a Post, without defining implementations, such as
 * persistence. This service employs the use of DTOs to prevent exposing internal
 * DB schema and return relevant data only.
 *
 * @author renato
 */
public interface PostService {
    
    /**
     * Service method to list all posts in a page.
     * @param pageable page parameters, including number, size and sorting options
     * @return a paged list of posts
     */
    public Page<PostDTO> findAll(Pageable pageable);
    
    /**
     * Service method to search a post by its ID.
     * @param postId post unique identifier
     * @return an optional possibly containing requested post, if found
     */
    public Optional<PostDTO> findById(Long postId);
    
    /**
     * Service method to create a new post. Returned created post should be used
     * for further processing, as its content may have been altered.
     * @param post new post
     * @return created post
     */
    public PostDTO create(PostDTO post);
    
    /**
     * Service method to update an existing post. Returned updated post should 
     * be used for further processing, as its content may have been altered.
     * @param post post to be updated
     * @return updated post
     */
    public PostDTO update(PostDTO post);
    
    /**
     * Service method to delete an existing post.
     * @param postId post unique identifier
     */
    public void delete(Long postId);
}
