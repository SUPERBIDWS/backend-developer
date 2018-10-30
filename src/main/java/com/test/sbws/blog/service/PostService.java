package com.test.sbws.blog.service;

import java.util.List;

import com.test.sbws.blog.dto.PostDTO;

public interface PostService {

	PostDTO save(PostDTO dto);
	
	PostDTO update(Long id, PostDTO dto);
	
	void deleteById(Long id);
	
	PostDTO findById(Long id);
	
	List<PostDTO> findAll(int page, int size);
	
}
