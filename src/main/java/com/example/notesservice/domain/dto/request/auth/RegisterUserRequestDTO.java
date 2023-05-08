package com.example.notesservice.domain.dto.request.auth;

import com.example.notesservice.enums.Gender;
import com.example.notesservice.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record RegisterUserRequestDTO(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank String email,
        @NotBlank String password,
        @NotNull Gender gender,
        @NotNull Role role
) {
}
