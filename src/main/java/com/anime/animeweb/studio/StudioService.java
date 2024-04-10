package com.anime.animeweb.studio;

import com.anime.animeweb.core.EntityService;
import com.anime.animeweb.core.EntityRepository;
import org.springframework.stereotype.Service;

@Service
public class StudioService extends EntityService<Studio> {
    public StudioService(EntityRepository<Studio> repository) {
        super(repository);
    }
}
