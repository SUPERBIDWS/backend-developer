package com.leo.blog.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.leo.blog.commons.exception.NotFoundException;
import com.leo.blog.core.entity.Post;
import com.leo.blog.core.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public Post findById(Integer id) {
		return postRepository.findById(id).orElseThrow(NotFoundException::new);
	}

	@Override
	public Page<Post> findAll(Pageable pageable) {
		return this.postRepository.findAll(pageable);
	}
	
	@Override
	public Page<Post> findByTitulto(Pageable pageable, String titulo) {
		return this.postRepository.findByTituloContaining(pageable, titulo);
	}
	
	@Override
	public Post save(Post post) {
		return this.postRepository.save(post);
	}

	@Override
	public Integer countById(Integer id) {
		return this.postRepository.countById(id);
	}

	@Override
	public void delete(Integer id) {
		this.postRepository.deleteById(id);
	}
	
}
