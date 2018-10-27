package com.sbws.blogserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbws.blogserver.model.Blog;
import com.sbws.blogserver.repository.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	BlogRepository repository;

	@Override
	public List<Blog> findAll() {
		return (List<Blog>) repository.findAll();
	}

	@Override
	public Blog findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Blog save(Blog blog) {
		return repository.save(blog);
	}

	@Override
	public String deleteById(Long id) {
		repository.deleteById(id);
		return "ok";
	}

}
