package com.sbws.blogserver.controller;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.sbws.blogserver.model.Blog;
import com.sbws.blogserver.service.BlogService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("/v1/blog/")
@Api(value = "Blog SBWS REST API", description = "Operações CRUD para Blog SBWS")
public class BlogController {
	
	private static final Logger log = LoggerFactory.getLogger(BlogController.class);
	
	@Autowired
	private BlogService service;
	
	@GetMapping
	@ApiOperation(value = "Busca todos posts do blog", response = Blog.class)
	public ResponseEntity<List<Blog>> allPosts() {
		return new ResponseEntity<List<Blog>>(service.findAll(), HttpStatus.PARTIAL_CONTENT);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Busca post por ID", response = Blog.class)
	public ResponseEntity<Blog> getById(@PathVariable("id") Long id) {
		
		Blog blog = service.findById(id);
		
		HttpStatus httpStatus = null;
		
		if(Objects.isNull(blog)) {
			httpStatus = HttpStatus.NOT_FOUND;
		} else {
			httpStatus = HttpStatus.OK;
		}
		
		return new ResponseEntity<Blog>(blog, httpStatus);
	}

	@PostMapping
	@ApiOperation(value = "Cria um POST no blog (ID é gerado automaticamente)", response = Blog.class)
	public ResponseEntity<Blog> post(@RequestBody Blog blog) {
		return new ResponseEntity<Blog>(service.save(blog), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Cria ou atualiza o Post do Blog (ID é necessário)", response = Blog.class)
	public ResponseEntity<Blog> put(@PathVariable("id") Long id, @RequestBody Blog blog) {
		return new ResponseEntity<Blog>(service.save(blog), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete o Post do Blog por ID", response = Blog.class)
	@Transactional
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		return new ResponseEntity<String>(service.deleteById(id), HttpStatus.OK);
	}
	
	@ExceptionHandler
	public ResponseEntity<String> errorHandle(Exception e, WebRequest request) {
		log.error("Ocorreu erro......");
		e.printStackTrace();
		return new ResponseEntity<String>("Ocorreu um erro: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
