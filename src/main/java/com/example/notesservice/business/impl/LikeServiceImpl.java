package com.example.notesservice.business.impl;

import com.example.notesservice.business.LikeService;
import com.example.notesservice.business.UserService;
import com.example.notesservice.domain.Like;
import com.example.notesservice.domain.dto.response.LikeResponseDTO;
import com.example.notesservice.enums.LikeType;
import com.example.notesservice.mapper.LikeMapper;
import com.example.notesservice.repository.LikeRepository;
import com.example.notesservice.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class LikeServiceImpl implements LikeService {

    private final NoteRepository noteRepository;
    private final LikeRepository likeRepository;
    private final UserService userService;
    private final LikeMapper mapper;

    @Override
    @Transactional
    public LikeResponseDTO createLike(String noteId, LikeType type, Authentication authentication) {
        var userName = authentication.getName();
        log.debug("Creating like for note with id: '{}', like type: '{}', user name: '{}'", noteId, type, userName);
        var user = userService.getUserByEmail(userName);
        var note = noteRepository.findById(noteId).orElseThrow(() -> new RuntimeException("Note not found by id: " + noteId));
        var like = note.getLikes().stream().filter(Objects::nonNull).filter(l -> l.getUserId().equals(user.getId())).findFirst()
                .orElseGet(() -> Like.builder().userId(user.getId()).noteId(noteId).build());
        like.setLikeType(type);
        note.addLike(like);
        likeRepository.save(like);
        noteRepository.save(note);

        return mapper.toDto(like);
    }
}
