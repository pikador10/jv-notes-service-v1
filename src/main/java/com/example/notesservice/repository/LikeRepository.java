package com.example.notesservice.repository;

import com.example.notesservice.domain.Like;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LikeRepository extends MongoRepository<Like, String> {

    Optional<Like> findByUserId(String userId);
}
