package com.anime.animeweb.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "studio")
@NoArgsConstructor
@AllArgsConstructor
public class Studio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer year;

    private String studio;

    @OneToMany(mappedBy = "studio")
    List<Anime> animeList;

}
