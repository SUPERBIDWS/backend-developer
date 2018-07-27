package net.superbid.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.net.URI;
import java.util.Optional;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import net.superbid.blog.dto.PostDTO;
import net.superbid.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Post REST web services.
 *
 * @author renato
 */
@Slf4j
@RestController
@RequestMapping("/posts")
@Api(value="post", description="Operations pertaining to posts in blog")
public class PostController {

    @Autowired
    private PostService postService;

    /**
     * Lists all posts using pagination. Pageable is a data structure containing
     * page number and size.
     * @param pageable page paramenters (page, size)
     * @return a paged list of posts
     */
    @ApiOperation(value = "List all posts in the blog using (optional) pagination")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping
    Page<PostDTO> listAllPosts(Pageable pageable) {
        log.trace("listAllPosts web service call, with pageable='" + pageable + "'.");
        return postService.findAll(pageable);
    }

    /**
     * Searches a single post using its unique identifier.
     * @param postId post ID
     * @return a response containing the requested post
     */
    @ApiOperation(value = "Search a post with an ID")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully found requested post"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<?> listPostById(@PathVariable(name = "id") Long postId) {
        log.trace("listPostById web service call, with id=" + postId + ".");
        return postService
                .findById(postId)
                .map(p -> {
                    return ResponseEntity.ok(p);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Create a new post.
     * @param post new post data
     * @return response containing a link to the newly created post
     */
    @ApiOperation(value = "Create a new post")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Successfully created a post"),
        @ApiResponse(code = 400, message = "Invalid post data provided")
    })
    @PostMapping
    ResponseEntity<?> create(@Valid @RequestBody PostDTO post) {
        log.trace("create web service call, with post=" + post + ".");
        PostDTO createdPost = postService.create(post);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdPost.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    /**
     * Updates an existing post.
     * @param postId post unique identifier
     * @param post post new data
     * @return response indicating operation result
     */
    @ApiOperation(value = "Update a post")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Successfully updated post"),
        @ApiResponse(code = 400, message = "Invalid post data provided"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable(name = "id") Long postId, @Valid @RequestBody PostDTO post) {
        log.trace("update web service call, with id=" + postId + ", post=" + post + ".");
        Optional<PostDTO> postOptional = postService.findById(postId);
        if (!postOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        post.setId(postId);
        postService.update(post);
        return ResponseEntity.noContent().build();
    }

    /**
     * Delete an existing post.
     * @param postId post unique identifier
     * @return response indicating operation result
     */
    @ApiOperation(value = "Delete a post")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully deleted post"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable(name = "id") Long postId) {
        log.trace("listPostById web service call, with id=" + postId + ".");
        Optional<PostDTO> postOptional = postService.findById(postId);
        if (!postOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        postService.delete(postId);
        return ResponseEntity.ok().build();
    }
}
