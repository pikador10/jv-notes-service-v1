package com.example.notesservice.domain.dto.response;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class NotesResponseDTO {
    private List<NoteResponseDTO> notes = new ArrayList<>();
}
