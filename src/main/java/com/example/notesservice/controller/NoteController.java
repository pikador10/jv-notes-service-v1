package com.example.notesservice.controller;

import com.example.notesservice.business.NoteService;
import com.example.notesservice.domain.dto.request.NoteRequestDTO;
import com.example.notesservice.domain.dto.response.NoteResponseDTO;
import com.example.notesservice.domain.dto.response.NotesResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Tag(name = "NOTE:USER:API")
@RequestMapping("/api/notes")
@RequiredArgsConstructor
@RestController
@SecurityRequirement(name = "JWT")
public class NoteController {

    private final NoteService noteService;

    @Operation(summary = "Get notes by user id")
    @GetMapping
    public NotesResponseDTO getNotes(@RequestParam(required = false) String userId) {
        return noteService.getNotes(userId);
    }

    @Operation(summary = "Create note")
    @PostMapping("/create")
    public NoteResponseDTO createNote(@RequestBody @Valid NoteRequestDTO request,
                                      Authentication authentication) {
        return noteService.createNote(request, authentication);
    }
}
