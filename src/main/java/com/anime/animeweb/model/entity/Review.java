package com.anime.animeweb.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "review")
public class Review {

    @Id
    @Column(name = "id_review")
    private Long idReview;

    private String contest;

    @ManyToOne
    @JoinColumn(name = "title_anime", referencedColumnName = "title_anime")
    private Anime anime;

    @OneToMany(mappedBy="review")
    private List<Comment> comments;
}
