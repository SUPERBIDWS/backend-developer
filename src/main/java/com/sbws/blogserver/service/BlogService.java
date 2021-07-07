package com.sbws.blogserver.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sbws.blogserver.model.Blog;

@Service
public interface BlogService {

	public List<Blog> findAll();

	public Blog findById(Long id);

	public Blog save(Blog blog);
	
	public String deleteById(Long id);

}
