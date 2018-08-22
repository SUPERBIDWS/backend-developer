package com.leo.blog.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leo.core.entity.Post;
import com.leo.core.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void create(Post post) {
		
		this.postRepository.save(post);
		
	}
	
}
