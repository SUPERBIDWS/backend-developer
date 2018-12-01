package net.superbid.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	

}
