package com.anime.animeweb.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "comment")
public class Comment {

    @Id
    private Long id;

    private String userLogin;

    private String comment;

    private LocalDateTime publishedDate;

    @ManyToOne
    @JoinColumn(name="review",referencedColumnName ="id_review")
    private Review review;

    @ManyToOne
    @JoinColumn(name="title_anime", referencedColumnName = "title_anime")
    private Anime anime;

}
