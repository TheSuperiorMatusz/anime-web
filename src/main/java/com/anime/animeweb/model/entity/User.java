package com.anime.animeweb.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    @Id @Column(length = 100)
    private String login;
    private int age;
    private String password;
    @Column(length = 20)
    private String name;
    @Column(length = 20)
    private String surname;
    private String description;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;


}
