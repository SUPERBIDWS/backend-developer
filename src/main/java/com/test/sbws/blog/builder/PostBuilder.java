package com.test.sbws.blog.builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.sbws.blog.dto.PostDTO;
import com.test.sbws.blog.entity.PostEntity;

@Component
public class PostBuilder {

	@Autowired
	private ModelMapper mapper;

	public PostDTO toDTO(PostEntity entity) {
		return mapper.map(entity, PostDTO.class);
	}

	public List<PostDTO> toListDTO(List<PostEntity> entities) {
		return entities.stream().map(e -> mapper.map(e, PostDTO.class))
				.collect(Collectors.toList());
	}

	public PostEntity toEntity(PostDTO dto) {
		dto.setPublishDatetime(LocalDateTime.now());
		return mapper.map(dto, PostEntity.class);
	}

}
