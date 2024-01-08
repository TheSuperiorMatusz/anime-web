package com.anime.animeweb.repositories;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Role extends JpaRepository<Role, Id> {
}
