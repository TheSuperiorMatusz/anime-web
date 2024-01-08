package com.anime.animeweb.repositories;

import com.anime.animeweb.model.entity.key.CreatedId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Creation extends JpaRepository<Creation, CreatedId> {
}
