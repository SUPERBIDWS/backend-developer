package br.com.denniscb.post.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import br.com.denniscb.post.exception.NotFoundException;
import br.com.denniscb.post.model.PostModel;
import br.com.denniscb.post.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public PostModel save(PostModel post) {
		return postRepository.save(post);
	}

	public List<PostModel> findAll() {
		List<PostModel> posts = postRepository.findAll();
		if(CollectionUtils.isEmpty(posts)) {
			throw new NotFoundException();
		}
		return posts;
	}

	public List<PostModel> findByTituloContaining(String titulo) {
		Optional<List<PostModel>> posts = postRepository.findByTituloContaining(titulo);
		if (!posts.isPresent()) {
			throw new NotFoundException();
		}
		return posts.get();
	}

	public PostModel findById(Long id) {
		Optional<PostModel> post = postRepository.findById(id);
		if (!post.isPresent()) {
			throw new NotFoundException();
		}
		return post.get();
	}

	public void delete(Long id) {
		postRepository.deleteById(id);
	}

}
