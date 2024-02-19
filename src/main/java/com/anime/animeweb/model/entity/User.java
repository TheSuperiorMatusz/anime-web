package com.anime.animeweb.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(length = 100)
    private String login;
    private int age;
    private String password;
    @Column(length = 20)
    private String name;
    @Column(length = 20)
    private String surname;
    private String description;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

}
