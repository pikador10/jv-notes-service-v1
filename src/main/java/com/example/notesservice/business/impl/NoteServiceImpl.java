package com.example.notesservice.business.impl;

import com.example.notesservice.business.NoteService;
import com.example.notesservice.business.UserService;
import com.example.notesservice.domain.Note;
import com.example.notesservice.domain.dto.request.NoteRequestDTO;
import com.example.notesservice.domain.dto.response.NoteResponseDTO;
import com.example.notesservice.domain.dto.response.NotesResponseDTO;
import com.example.notesservice.mapper.NoteMapper;
import com.example.notesservice.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Slf4j
@RequiredArgsConstructor
@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final UserService userService;
    private final NoteMapper mapper;

    @Override
    public NotesResponseDTO getNotes(String userId) {
        log.debug("Get all notes by user id: '{}'", userId);
        var notes = userId == null
                ? noteRepository.findAllByOrderByCreatedDateDesc()
                : noteRepository.findAllByUserIdOrderByCreatedDateDesc(userId);
        var response = notes.stream()
                .map(mapper::toDto)
                .toList();

        return NotesResponseDTO.builder()
                .notes(response)
                .build();
    }

    @Override
    @Transactional
    public NoteResponseDTO createNote(NoteRequestDTO request, Authentication authentication) {
        var userId = getUserId(authentication);
        var note = Note.builder()
                .userId(userId)
                .comment(request.comment())
                .likes(new HashSet<>())
                .build();
        noteRepository.save(note);

        return mapper.toDto(note);
    }

    private String getUserId(Authentication authentication) {
        if (authentication != null) {
            var name = authentication.getName();
            log.debug("Process note creation for authentication user by name: '{}'", name);
            var user = userService.getUserByEmail(name);
            return user.getId();
        }

        log.debug("Process note creation for no authentication user");
        return null;
    }
}
