package com.leo.blog.core.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.leo.blog.core.entity.Post;

public interface PostService {
	Post save(Post post);
	Post findById(Integer id);
	Page<Post> findAll(Pageable pageable);
	Page<Post> findByTitulto(Pageable pageable, String titulo);
	Integer countById(Integer id);
	void delete(Integer id);
}
