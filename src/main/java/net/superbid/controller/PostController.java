package net.superbid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.superbid.entity.Post;
import net.superbid.services.PostServices;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostServices postServices;
	
	@GetMapping
	public ResponseEntity<List<Post>> listar() {
		
		List<Post> posts = postServices.listar();
		return ResponseEntity.status(HttpStatus.OK).body(posts);
}
	

}
