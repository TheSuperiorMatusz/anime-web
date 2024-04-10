package com.anime.animeweb.studio;


import com.anime.animeweb.anime.Anime;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Studio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer year;

    private String country;

    @OneToMany(mappedBy = "studio")
    List<Anime> animeList;

}
