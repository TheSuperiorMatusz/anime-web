package com.anime.animeweb.service;

import com.anime.animeweb.model.entity.User;
import com.anime.animeweb.repository.EntityRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends EntityService<User> {
    public UserService(EntityRepository<User> repository) {
        super(repository);
    }
}
