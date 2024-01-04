package com.anime.animeweb.model.entity;

import com.anime.animeweb.model.entity.key.AnimeKey;
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
@Table(name = "anime")
@IdClass(AnimeKey.class)
public class Anime {

    @Id
    private String title;

    @Id
    private Integer year;

    private String description;

    @OneToMany
    @JoinColumn(name = "title")
    private List<Review> reviewList;
}
