package br.com.denniscb.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;


import br.com.denniscb.post.model.PostModel;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long> {
	
	public Optional<List<PostModel>> findByTituloContaining(String titulo);
}
