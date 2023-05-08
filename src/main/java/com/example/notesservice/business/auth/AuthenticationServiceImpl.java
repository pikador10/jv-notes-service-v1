package com.example.notesservice.business.auth;

import com.example.notesservice.domain.User;
import com.example.notesservice.domain.dto.request.auth.RegisterUserRequestDTO;
import com.example.notesservice.domain.dto.response.auth.AuthenticationUserResponseDto;
import com.example.notesservice.repository.UserRepository;
import com.example.notesservice.security.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final TokenProvider tokenProvider;

    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationUserResponseDto registerUser(RegisterUserRequestDTO request) {
        var user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(request.role())
                .gender(request.gender())
                .build();
        userRepository.save(user);

        var token = tokenProvider.generateToken(user);
        return new AuthenticationUserResponseDto(token);
    }
}
