package com.anime.animeweb.user;

import com.anime.animeweb.comment.Comment;
import com.anime.animeweb.role.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
