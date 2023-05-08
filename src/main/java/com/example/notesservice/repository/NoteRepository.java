package com.example.notesservice.repository;

import com.example.notesservice.domain.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {

    List<Note> findAllByUserIdOrderByCreatedDateDesc(String userId);

    List<Note> findAllByOrderByCreatedDateDesc();
}
