package com.anime.animeweb.services;

import com.anime.animeweb.model.entity.Anime;
import com.anime.animeweb.repositories.EntityRepository;

public class AnimeService extends EntityService<Anime> {
    public AnimeService(EntityRepository<Anime> repository) {
        super(repository);
    }
}
