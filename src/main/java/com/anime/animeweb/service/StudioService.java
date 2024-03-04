package com.anime.animeweb.service;

import com.anime.animeweb.model.entity.Studio;
import com.anime.animeweb.repository.EntityRepository;
import org.springframework.stereotype.Service;

@Service
public class StudioService extends EntityService<Studio> {
    public StudioService(EntityRepository<Studio> repository) {
        super(repository);
    }
}
