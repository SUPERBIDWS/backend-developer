package com.ibeans.blog.application.shared;

import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;

import java.util.Optional;

/**
 * Created by igotavares on 07/08/2018.
 */
@RequiredArgsConstructor
public class Converter<ENTITY, DTO> {

    private final Mapper mapper;
    private final Class<ENTITY> entityClass;
    private final Class<DTO> dtoClass;

    public DTO toDTO(Optional<ENTITY> entity) {
        return entity.map(this::toDTO)
                .orElse(null);
    }

    public DTO toDTO(ENTITY entity) {
        return mapper.map(entity, dtoClass);
    }

    public ENTITY toEntity(DTO dto) {
        return mapper.map(dto, entityClass);
    }

}
