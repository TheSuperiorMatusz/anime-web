package com.anime.animeweb.user;

import com.anime.animeweb.core.EntityRepository;
import com.anime.animeweb.core.EntityService;
import org.springframework.stereotype.Service;

@Service
public class UserService extends EntityService<User> {
    public UserService(EntityRepository<User> repository) {
        super(repository);
    }
}
