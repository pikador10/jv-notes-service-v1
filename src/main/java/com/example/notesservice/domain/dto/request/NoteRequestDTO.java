package com.example.notesservice.domain.dto.request;

import jakarta.validation.constraints.NotBlank;

public record NoteRequestDTO(
        @NotBlank
        String comment
) {
}
