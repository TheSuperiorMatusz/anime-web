package com.anime.animeweb.services;

import com.anime.animeweb.model.entity.Studio;
import com.anime.animeweb.repositories.EntityRepository;

public class StudioService extends EntityService<Studio> {
    public StudioService(EntityRepository<Studio> repository) {
        super(repository);
    }
}
