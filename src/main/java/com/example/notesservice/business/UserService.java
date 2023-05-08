package com.example.notesservice.business;

import com.example.notesservice.domain.User;
import com.example.notesservice.domain.dto.response.UserResponseDTO;
import com.example.notesservice.domain.dto.response.UsersResponseDTO;

public interface UserService {

    User getUserByEmail(String email);

    UserResponseDTO getUserByName(String name);

    void deleteUserById(String userId);

    UsersResponseDTO getAllUsers();
}
