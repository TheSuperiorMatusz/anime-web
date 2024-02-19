package com.anime.animeweb.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "anime")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;


    private Integer year;

    private String description;

    @ManyToOne
    @JoinColumn(name = "studio_id")
    private Studio studio;


    @OneToMany(mappedBy = "anime")
    private List<Review> reviewList;


}
