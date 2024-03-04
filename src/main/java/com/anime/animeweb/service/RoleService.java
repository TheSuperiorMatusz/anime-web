package com.anime.animeweb.service;

import com.anime.animeweb.model.entity.Role;
import com.anime.animeweb.repository.EntityRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends EntityService<Role> {
    public RoleService(EntityRepository<Role> repository) {
        super(repository);
    }
}
