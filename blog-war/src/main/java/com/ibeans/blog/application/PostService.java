package com.ibeans.blog.application;


import com.ibeans.blog.dta.PostDTO;

import java.util.List;

/**
 * Created by igotavares on 07/08/2018.
 */
public interface PostService {

    PostDTO save(PostDTO post);

    List<PostDTO> findAll();

    PostDTO findBy(Long id);

    void delete(Long id);

    void update(PostDTO post, Long id);
}
