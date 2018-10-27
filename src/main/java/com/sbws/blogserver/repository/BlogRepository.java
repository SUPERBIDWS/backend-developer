package com.sbws.blogserver.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sbws.blogserver.model.Blog;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Long>{

}

