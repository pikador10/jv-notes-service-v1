package com.example.notesservice.mapper;

import com.example.notesservice.domain.Like;
import com.example.notesservice.domain.dto.response.LikeResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LikeMapper {

    LikeResponseDTO toDto(Like like);
}
