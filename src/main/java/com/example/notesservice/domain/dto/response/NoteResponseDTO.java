package com.example.notesservice.domain.dto.response;

import com.example.notesservice.domain.Like;
import lombok.Builder;

import java.util.Set;

@Builder
public record NoteResponseDTO(
        String noteId,
        String userId,
        String comment,
        Set<Like> likes
) {
}
