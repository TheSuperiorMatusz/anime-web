package com.anime.animeweb.comment;

import com.anime.animeweb.review.Review;
import com.anime.animeweb.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String comment;

    private LocalDateTime publishedDate;

    @ManyToOne
    @JoinColumn(name = "id_review")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
