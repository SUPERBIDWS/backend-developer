package net.superbid.services;

import java.util.List;
import java.util.Optional;

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

	public Optional<Post> buscaId(Long id) {
		
		 Optional<Post> post = postRepository.findById(id);
		 return post;
	}

}
