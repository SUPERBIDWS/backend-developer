package com.leo.blog.ws.post;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leo.blog.commons.exception.BindingException;
import com.leo.blog.commons.exception.NotFoundException;
import com.leo.blog.core.entity.Post;
import com.leo.blog.core.services.PostService;

@RestController
@RequestMapping("post")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable Integer id){
		Post post = this.postService.findById(id);
		PostDTO postDTO = PostDTO.from(post);
		return ResponseEntity.ok(postDTO);
	}
	
	@GetMapping
	public ResponseEntity<Page<PostDTO>> findAll(Pageable pageable){
		Page<Post> pages = this.postService.findAll(pageable);
		Page<PostDTO> pageDTO = pages.map(PostDTO::from);
		return ResponseEntity.ok(pageDTO);
	}
	
	@GetMapping("/by-titulo")
	public ResponseEntity<Page<PostDTO>> findByTitulo(@RequestParam String titulo, Pageable pageable){
		Page<Post> pages = this.postService.findByTitulto(pageable, titulo);
		Page<PostDTO> pageDTO = pages.map(PostDTO::from);
		return ResponseEntity.ok(pageDTO);
	}
	
	@PutMapping("/{id}") 
	public ResponseEntity<PostDTO> update(@PathVariable Integer id, @Valid @RequestBody PostDTO data, BindingResult results){
		if(results.hasErrors()) {
			throw new BindingException(results);
		}
		if(this.postService.countById(id) < 1) {
			throw new NotFoundException();
		}
		Post post = this.postService.save(Post.builder()
											  .id(data.getId())
											  .titulo(data.getTitulo())
											  .dataPublicacao(data.getDataPublicacao())
											  .descricao(data.getDescricao())
											  .build());
		PostDTO postDTO = PostDTO.from(post);
		return ResponseEntity.ok(postDTO);
	}
	
	@PostMapping
	public ResponseEntity<PostDTO> create(@Valid @RequestBody PostDTO data, BindingResult results) {
		if(results.hasErrors()) {
			throw new BindingException(results);
		}
		Post post = this.postService.save(data.build());
		PostDTO postDTO = PostDTO.from(post);
		return ResponseEntity.status(HttpStatus.CREATED).body(postDTO);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if(this.postService.countById(id) < 1) {
			throw new NotFoundException();
		}
		this.postService.delete(id);
	}

}
