package com.test.sbws.blog.rest.controller;

import org.springframework.http.ResponseEntity;

import com.test.sbws.blog.dto.PostDTO;

@SuppressWarnings("rawtypes")
public interface PostController {
	
	ResponseEntity insert(PostDTO postDTO);

	ResponseEntity update(Long id, PostDTO postDTO);
	
	ResponseEntity deleteById(Long id);
	
	ResponseEntity findById(Long id);
	
	ResponseEntity findAll(int page, int size);
	
}
