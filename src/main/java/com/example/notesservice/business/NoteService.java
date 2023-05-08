package com.example.notesservice.business;

import com.example.notesservice.domain.dto.request.NoteRequestDTO;
import com.example.notesservice.domain.dto.response.NoteResponseDTO;
import com.example.notesservice.domain.dto.response.NotesResponseDTO;
import org.springframework.security.core.Authentication;

public interface NoteService {
    NotesResponseDTO getNotes(String userId);

    NoteResponseDTO createNote(NoteRequestDTO request, Authentication authentication);
}
