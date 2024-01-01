package com.anime.animeweb.model.entity.key;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class AnimeKey implements Serializable {

    private String title;
    private Integer year;

}
