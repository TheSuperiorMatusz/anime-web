package com.anime.animeweb.model.entity;

import com.anime.animeweb.model.entity.key.CreatedId;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "created")
@EqualsAndHashCode
@NoArgsConstructor
public class Creation{


    @EmbeddedId
    private CreatedId id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "name_studio", referencedColumnName = "name", insertable = false, updatable = false),
            @JoinColumn(name = "year_studio", referencedColumnName = "year", insertable = false, updatable = false)
    })
    private Studio studio;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "title_anime", referencedColumnName = "title", insertable = false, updatable = false),
            @JoinColumn(name = "year_anime", referencedColumnName = "year", insertable = false, updatable = false)
    })
    private Anime anime;

}
