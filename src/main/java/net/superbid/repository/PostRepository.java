package net.superbid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.superbid.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
