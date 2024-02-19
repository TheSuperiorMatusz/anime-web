package com.anime.animeweb.model.entity;

import com.anime.animeweb.model.entity.enums.UserRole;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private UserRole roleName;

    public Role(UserRole roleName) {
        this.roleName = roleName;
    }

    @OneToMany(mappedBy = "role")
    private List<User> users;

}
