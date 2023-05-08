package com.example.notesservice.domain;

import com.example.notesservice.enums.LikeType;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document("like")
public class Like {

    @Id
    private String id;

    private String noteId;

    @Indexed
    private String userId;

    @Enumerated(EnumType.STRING)
    private LikeType likeType;
}
