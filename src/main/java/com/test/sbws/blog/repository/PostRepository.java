package com.test.sbws.blog.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.test.sbws.blog.entity.PostEntity;

@Repository
public interface PostRepository extends PagingAndSortingRepository<PostEntity, Long> {

}
