package com.example.notesservice.controller;

import com.example.notesservice.business.UserService;
import com.example.notesservice.domain.dto.response.UserResponseDTO;
import com.example.notesservice.domain.dto.response.UsersResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "USER:ADMIN:API")
@RequestMapping("/api/users")
@RequiredArgsConstructor
@RestController
@SecurityRequirement(name = "JWT")
public class UserController {

    private final UserService userService;

    @Operation(summary = "Get user by name")
    @GetMapping("/{name}")
    public UserResponseDTO getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @Operation(summary = "Get all users")
    @GetMapping
    public UsersResponseDTO getAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Delete user by id")
    @DeleteMapping("/delete/{userId}")
    public void deleteUserById(@PathVariable String userId) {
        userService.deleteUserById(userId);
    }
}
