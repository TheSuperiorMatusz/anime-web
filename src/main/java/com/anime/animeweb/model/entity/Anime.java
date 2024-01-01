package com.anime.animeweb.model.entity;

import com.anime.animeweb.model.entity.key.AnimeKey;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
}
