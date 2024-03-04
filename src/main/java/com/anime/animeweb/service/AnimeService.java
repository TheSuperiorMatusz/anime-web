package com.anime.animeweb.service;

import com.anime.animeweb.model.entity.Anime;
import com.anime.animeweb.repository.EntityRepository;
import org.springframework.stereotype.Service;

@Service
public class AnimeService extends EntityService<Anime> {
    public AnimeService(EntityRepository<Anime> repository) {
        super(repository);
    }
}
