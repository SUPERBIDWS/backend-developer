package com.test.sbws.blog.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.test.sbws.blog.builder.PostBuilder;
import com.test.sbws.blog.dto.PostDTO;
import com.test.sbws.blog.entity.PostEntity;
import com.test.sbws.blog.exceptions.EntityNotFoundException;
import com.test.sbws.blog.exceptions.SaveUpdateException;
import com.test.sbws.blog.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository repository;

	@Autowired
	private PostBuilder builder;

	@Override
	public PostDTO save(PostDTO dto) {
		return Optional.of(dto).map(builder::toEntity).map(repository::save)
				.map(PostEntity::getId).map(repository::findById)
				.map(o -> builder.toDTO(o.get()))
				.orElseThrow(SaveUpdateException::new);
	}

	public PostDTO update(Long id, PostDTO postDTO) {

		if (!repository.findById(id).isPresent()) {
			throw new EntityNotFoundException();
		}

		return Optional.of(postDTO).map(builder::toEntity).map(setId(id))
				.map(repository::save).map(builder::toDTO).get();

	}

	@Override
	public void deleteById(Long id) {
		Optional.of(id).ifPresent(repository::deleteById);
	}

	@Override
	public PostDTO findById(Long id) {
		return Optional.of(id).map(repository::findById)
				.map(o -> builder.toDTO(o.get()))
				.orElseThrow(EntityNotFoundException::new);
	}

	@SuppressWarnings("deprecation")
	public List<PostDTO> findAll(int page, int size) {

		return Optional
				.of(repository.findAll(new PageRequest(--page, size))
						.getContent().stream().map(builder::toDTO)
						.collect(Collectors.toList()))
				.orElseThrow(EntityNotFoundException::new);
	}

	private Function<PostEntity, PostEntity> setId(Long id) {
		return postEntity -> {
			postEntity.setId(id);
			return postEntity;
		};
	}

}
