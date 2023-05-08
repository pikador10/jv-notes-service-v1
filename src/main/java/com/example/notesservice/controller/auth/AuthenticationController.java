package com.example.notesservice.controller.auth;

import com.example.notesservice.business.auth.AuthenticationService;
import com.example.notesservice.domain.dto.request.auth.RegisterUserRequestDTO;
import com.example.notesservice.domain.dto.response.auth.AuthenticationUserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Auth:API")
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Operation(description = "Register user")
    @PostMapping("/register")
    public ResponseEntity<AuthenticationUserResponseDto> registerUser(@RequestBody @Valid RegisterUserRequestDTO request) {
        return ResponseEntity.ok(authenticationService.registerUser(request));
    }
}
