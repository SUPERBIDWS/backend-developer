package net.superbid.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import net.superbid.dto.PostDTO;
import net.superbid.entity.Post;
import net.superbid.services.PostServices;

@RestController
@RequestMapping("/blog")
public class PostController {

	@Autowired
	private PostServices postServices;

	@GetMapping("/post")
	public ResponseEntity<Map<String, Object>> listar() {

		List<Post> posts = postServices.listar();
		Map<String, Object> retorno = new HashMap<>();
		retorno.put("posts", posts);

		return ResponseEntity.status(HttpStatus.OK).body(retorno);
	}

	@GetMapping("/post/{id}")
	public ResponseEntity<Post> buscaPostPorId(@PathVariable Long id) {

		Optional<Post> post = postServices.buscaId(id);

		if (!post.isPresent())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Post());

		return ResponseEntity.status(HttpStatus.OK).body(post.get());
	}
	
	@PostMapping("post")
	public ResponseEntity<Post> persistirPost(@Valid @RequestBody PostDTO postDTO, BindingResult result) {
		
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(new Post());
		}

		Post postSalvo = postServices.salvar(postDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(postDTO.getId())
				.toUri();

		return ResponseEntity.created(location).body(postSalvo);
		
	}
	
	
	
	

}
