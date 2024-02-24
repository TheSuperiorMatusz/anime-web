package com.anime.animeweb.services;

import com.anime.animeweb.model.entity.User;
import com.anime.animeweb.repositories.EntityRepository;

public class UserService extends EntityService<User> {
    public UserService(EntityRepository<User> repository) {
        super(repository);
    }
}
