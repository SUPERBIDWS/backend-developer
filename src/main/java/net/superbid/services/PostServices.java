package net.superbid.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.superbid.entity.Post;
import net.superbid.repository.PostRepository;

@Service
public class PostServices {

	@Autowired
	private PostRepository postRepository;
	
	public List<Post> listar() {
		return postRepository.findAll();
	}

}
