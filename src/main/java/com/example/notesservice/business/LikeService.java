package com.example.notesservice.business;

import com.example.notesservice.domain.dto.response.LikeResponseDTO;
import com.example.notesservice.enums.LikeType;
import org.springframework.security.core.Authentication;

public interface LikeService {
    LikeResponseDTO createLike(String noteId, LikeType type, Authentication authentication);
}
