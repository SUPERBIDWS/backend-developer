package net.superbid.blog.repository;

import net.superbid.blog.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA repository interface for Posts' persistence operations. By extending
 * Spring's JPARepository interface, all CRUD methods are implemented by Spring,
 * including the use of pagination and sorting for listing methods. Other query
 * methods can be included using Spring Query Creation strategy.
 *
 * @author renato
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    
}
