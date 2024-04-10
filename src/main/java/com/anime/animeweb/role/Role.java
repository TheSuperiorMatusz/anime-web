package com.anime.animeweb.role;

import com.anime.animeweb.user.User;
import com.anime.animeweb.role.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserRole roleName;


    @OneToMany(mappedBy = "role")
    private List<User> users;

}
