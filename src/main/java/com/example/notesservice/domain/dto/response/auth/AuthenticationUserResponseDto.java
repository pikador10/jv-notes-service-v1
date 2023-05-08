package com.example.notesservice.domain.dto.response.auth;

import lombok.Builder;

@Builder
public record AuthenticationUserResponseDto(String token) {
}
