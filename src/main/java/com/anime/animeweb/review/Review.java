package com.anime.animeweb.review;

import com.anime.animeweb.anime.Anime;
import com.anime.animeweb.comment.Comment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Review {

    @Id
    @Column(name = "id_review")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReview;

    private String contest;

    @ManyToOne
    @JoinColumn(name = "anime_id")
    private Anime anime;

    @OneToMany(mappedBy = "review")
    private List<Comment> comments;
}
