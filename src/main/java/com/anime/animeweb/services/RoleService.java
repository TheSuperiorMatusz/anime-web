package com.anime.animeweb.services;

import com.anime.animeweb.model.entity.Role;
import com.anime.animeweb.repositories.EntityRepository;

public class RoleService extends EntityService<Role> {
    public RoleService(EntityRepository<Role> repository) {
        super(repository);
    }
}
