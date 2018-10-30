package com.test.sbws.blog.rest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.sbws.blog.dto.PostDTO;
import com.test.sbws.blog.service.PostService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/posts")
@SuppressWarnings("rawtypes")
public class PostControllerImpl implements PostController {

	@Autowired
	private PostService postService;

	@Override
	@ApiOperation(value = "Insert a post")
	@PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity insert(@Valid @RequestBody PostDTO postDTO) {
		postService.save(postDTO);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@Override
	@ApiOperation(value = "Update post")
	@PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity update(@PathVariable Long id,
			@Valid @RequestBody PostDTO postDTO) {
		postService.update(id, postDTO);
		return ResponseEntity.noContent().build();
	}

	@Override
	@ApiOperation(value = "Delete post by id")
	@DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity deleteById(@PathVariable Long id) {
		postService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	@ApiOperation(value = "Get post by id")
	@GetMapping(path = "/{id}")
	public ResponseEntity findById(@PathVariable Long id) {
		return ResponseEntity.ok(postService.findById(id));
	}

	@Override
	@ApiOperation(value = "Get all posts indicating page number and page size at url")
	@GetMapping(path = "/", params = {"page",
			"size"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity findAll(@RequestParam("page") int page,
			@RequestParam("size") int size) {
		return ResponseEntity.ok(postService.findAll(page, size));
	}

}
