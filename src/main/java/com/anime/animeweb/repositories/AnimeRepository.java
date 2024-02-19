package com.anime.animeweb.repositories;

import com.anime.animeweb.model.entity.Anime;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends EntityRepository<Anime, Long> {
}
