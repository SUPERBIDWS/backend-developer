package br.com.denniscb.post.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.denniscb.post.model.PostModel;
import br.com.denniscb.post.service.PostService;

@RestController
@RequestMapping("/api")
public class PostController {

	@Autowired
	private PostService postService;

	@PostMapping("/post")
	public ResponseEntity<PostModel> save(@Valid @RequestBody PostModel post) {
		return ResponseEntity.ok(postService.save(post));
	}

	@GetMapping("/post")
	public ResponseEntity<List<PostModel>> findAll() {
		return ResponseEntity.ok(postService.findAll());
	}

	@GetMapping("/post/titulo/{titulo}")
	public ResponseEntity<List<PostModel>> findByTituloContaining(@PathVariable(value = "titulo") String titulo) {
		return ResponseEntity.ok(postService.findByTituloContaining(titulo));
	}

	@GetMapping("/post/id/{id}")
	public ResponseEntity<PostModel> findByid(@PathVariable(value = "id") Long id) {
		return ResponseEntity.ok(postService.findById(id));
	}
	
	@DeleteMapping("/post/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		postService.delete(id);
		return ResponseEntity.ok().build();	
	}
	
}
