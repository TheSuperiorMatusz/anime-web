package com.anime.animeweb.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "comment")
public class Comment {

    @Id
    private Long id;


    private String comment;

    private LocalDateTime publishedDate;

    @ManyToOne
    @JoinColumn(name = "id_review")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "user_Login")
    private User user;

}
