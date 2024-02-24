package com.anime.animeweb.repositories;

import com.anime.animeweb.model.entity.Studio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends CrudRepository<Studio, Long> {
}
