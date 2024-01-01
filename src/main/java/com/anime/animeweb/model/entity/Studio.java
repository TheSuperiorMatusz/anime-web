package com.anime.animeweb.model.entity;


import com.anime.animeweb.model.entity.key.StudioKey;
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
@Table(name = "studio")
@NoArgsConstructor
@EqualsAndHashCode
@IdClass(StudioKey.class)
public class Studio {

    @Id
    private String name;

    @Id
    private Integer year;

    private String studio;
}
