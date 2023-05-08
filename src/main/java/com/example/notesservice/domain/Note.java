package com.example.notesservice.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document("note")
public class Note {

    @Id
    private String id;

    private String userId;

    private String comment;

    @DBRef
    private Set<Like> likes;

    @CreatedDate
    protected Instant createdDate = Instant.now();

    @LastModifiedDate
    protected Instant lastModifiedDate = Instant.now();

    public void addLike(Like like) {
        likes.add(like);
    }

    public void deleteLike(Like like) {
        likes.remove(like);
    }
}
