package com.ibeans.blog.application.impl;

import com.ibeans.blog.application.PostService;
import com.ibeans.blog.application.shared.Converter;
import com.ibeans.blog.domain.post.Post;
import com.ibeans.blog.domain.post.PostValidation;
import com.ibeans.blog.dta.PostDTO;
import com.ibeans.blog.exception.PostNotFoundException;
import com.ibeans.blog.infrastructure.jpa.PostRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by igotavares on 07/08/2018.
 */
@Service
public class PostServiceImpl implements PostService {

    private PostValidation validation;
    private PostRepository repository;
    private Converter<Post, PostDTO> converter;

    @Autowired
    public PostServiceImpl(Mapper mapper, PostRepository repository, PostValidation validation) {
        this.converter = new Converter(mapper, Post.class, PostDTO.class);
        this.validation = validation;
        this.repository = repository;
    }

    @Override
    public PostDTO save(PostDTO post) {
        return Optional.of(post)
                .map(converter::toEntity)
                .map(repository::save)
                .map(Post::getId)
                .map(PostDTO::new)
                .orElse(null);
    }

    @Override
    public void update(PostDTO post, Long id) {
        validation.exists(id);
        Optional.of(post)
                .map(converter::toEntity)
                .map(setId(id))
                .ifPresent(repository::save);
    }

    private Function<Post, Post> setId(Long id) {
        return convertedPost -> {
            convertedPost.setId(id);
            return convertedPost;
        };
    }

    @Override
    public PostDTO findBy(Long id) {
        return Optional.of(id)
                .map(repository::findById)
                .map(converter::toDTO)
                .orElseThrow(PostNotFoundException::new);
    }

    @Override
    public List<PostDTO> findAll() {
        return repository.findAll().stream()
                .map(converter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        validation.exists(id);
        Optional.of(id).ifPresent(repository::deleteById);
    }

}
