package com.example.notesservice.business.impl;

import com.example.notesservice.business.UserService;
import com.example.notesservice.domain.User;
import com.example.notesservice.domain.dto.response.UserResponseDTO;
import com.example.notesservice.domain.dto.response.UsersResponseDTO;
import com.example.notesservice.mapper.UserMapper;
import com.example.notesservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User getUserByEmail(String email) {
        log.debug("Delete user by email: '{}'", email);
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User was not found by email: " + email));
    }

    @Override
    public UserResponseDTO getUserByName(String name) {
        log.debug("Delete user by name: '{}'", name);
        return userMapper.toDto(getUserByEmail(name));
    }

    @Override
    @Transactional
    public void deleteUserById(String userId) {
        log.debug("Delete user by id: '{}'", userId);
        userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User was not found by id: " + userId));
        userRepository.deleteById(userId);
    }

    @Override
    public UsersResponseDTO getAllUsers() {
        log.debug("Get all users");
        var users = userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
        return new UsersResponseDTO(users);
    }
}
