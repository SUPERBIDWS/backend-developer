package com.ibeans.blog.domain.post;

import com.ibeans.blog.exception.PostNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by igotavares on 07/08/2018.
 */
@Component
public class PostValidation {

    private final PostSearch search;

    @Autowired
    public PostValidation(PostSearch search) {
        this.search = search;
    }

    public void exists(Long id) {
        if (!search.existsById(id)) {
            throw new PostNotFoundException();
        }
    }

}
