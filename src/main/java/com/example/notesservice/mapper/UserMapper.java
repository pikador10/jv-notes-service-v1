package com.example.notesservice.mapper;

import com.example.notesservice.domain.User;
import com.example.notesservice.domain.dto.response.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "userId", source = "id")
    UserResponseDTO toDto(User user);
}
