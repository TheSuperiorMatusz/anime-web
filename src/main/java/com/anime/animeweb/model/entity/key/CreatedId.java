package com.anime.animeweb.model.entity.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Embeddable
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CreatedId implements Serializable {
    @Column(name = "name_studio")
    private String nameStudio;

    @Column(name = "year_studio")
    private Integer yearStudio;

    @Column(name = "title_anime")
    private String titleAnime;

    @Column(name = "year_anime")
    private Integer yearAnime;
}
