package com.example.notesservice.mapper;

import com.example.notesservice.domain.Note;
import com.example.notesservice.domain.dto.response.NoteResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    @Mapping(target = "noteId", source = "id")
    NoteResponseDTO toDto(Note note);
}
