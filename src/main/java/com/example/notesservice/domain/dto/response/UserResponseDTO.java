package com.example.notesservice.domain.dto.response;

import com.example.notesservice.enums.Gender;
import lombok.Builder;

@Builder
public record UserResponseDTO(String userId,
                              String firstName,
                              String lastName,
                              String email,
                              Gender gender
) {
}
