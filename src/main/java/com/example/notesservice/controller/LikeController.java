package com.example.notesservice.controller;

import com.example.notesservice.business.LikeService;
import com.example.notesservice.domain.dto.response.LikeResponseDTO;
import com.example.notesservice.enums.LikeType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Tag(name = "LIKE:USER:API")
@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
@SecurityRequirement(name = "JWT")
public class LikeController {

    private final LikeService likeService;

    @Operation(description = "Add like to note")
    @PostMapping("/notes/{noteId}/likes/create")
    public LikeResponseDTO createLike(@PathVariable String noteId,
                                      @RequestParam @Valid @NonNull LikeType type,
                                      Authentication authentication) {
        return likeService.createLike(noteId, type, authentication);
    }
}
