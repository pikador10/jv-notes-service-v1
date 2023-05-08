package com.example.notesservice.domain.dto.response;

import com.example.notesservice.enums.LikeType;
import lombok.Builder;

@Builder
public record LikeResponseDTO(
        String id,
        String noteId,
        String userId,
        LikeType likeType
) {
}
