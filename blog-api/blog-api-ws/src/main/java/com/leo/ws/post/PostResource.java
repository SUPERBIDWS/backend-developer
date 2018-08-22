package com.leo.ws.post;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.blog.core.services.PostService;

@RestController
@RequestMapping("post")
public class PostResource {
	
	private static Logger LOGGER = Logger.getLogger(PostResource.class.getName());
	
	@Autowired
	private PostService postService;
	
	@PostMapping(produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Integer> create(@Valid @RequestBody PostDTO data, BindingResult results) {
		
		try {
			
//			if(results.hasErrors()) {
//				throw new BindingException(results);
//			}
			
//			Post post = data.build();
			
			
			
//			this.postService.create(post);
			
			return null; //ResponseEntity.ok(Post.getId()).build();
			
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	}

}
