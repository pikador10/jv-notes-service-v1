package com.example.notesservice.business.auth;

import com.example.notesservice.domain.dto.request.auth.RegisterUserRequestDTO;
import com.example.notesservice.domain.dto.response.auth.AuthenticationUserResponseDto;

public interface AuthenticationService {
    AuthenticationUserResponseDto registerUser(RegisterUserRequestDTO request);
}
