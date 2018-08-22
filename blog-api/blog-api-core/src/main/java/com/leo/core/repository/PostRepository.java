package com.leo.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leo.core.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
