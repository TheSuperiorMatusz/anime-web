package com.anime.animeweb.user;

import com.anime.animeweb.core.EntityRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends EntityRepository<User> {
    Optional<User> findByLogin(String login);
}
