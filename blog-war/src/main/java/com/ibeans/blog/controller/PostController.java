package com.ibeans.blog.controller;

import com.ibeans.blog.application.PostService;
import com.ibeans.blog.dta.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by igotavares on 07/08/2018.
 */
@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDTO save(@RequestBody PostDTO post) {
        return service.save(post);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody PostDTO post, @PathVariable Long id) {
        service.update(post, id);
    }

    @GetMapping
    public List<PostDTO> all() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public PostDTO get(@PathVariable Long id) {
        return service.findBy(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }


}
