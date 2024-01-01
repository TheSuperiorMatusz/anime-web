package com.anime.animeweb.model.entity.key;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class StudioKey implements Serializable {
    private String name;
    private Integer year;
}
