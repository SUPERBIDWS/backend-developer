package com.ibeans.blog.infrastructure.jpa;

import com.ibeans.blog.domain.post.Post;
import com.ibeans.blog.domain.post.PostSearch;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by igotavares on 07/08/2018.
 */
public interface PostRepository extends CrudRepository<Post, Long>, PostSearch {

    List<Post> findAll();

}
