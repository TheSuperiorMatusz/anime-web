package com.anime.animeweb.anime;

import com.anime.animeweb.core.EntityRepository;
import com.anime.animeweb.core.EntityService;
import org.springframework.stereotype.Service;

@Service
public class AnimeService extends EntityService<Anime> {
    public AnimeService(EntityRepository<Anime> repository) {
        super(repository);
    }
}
