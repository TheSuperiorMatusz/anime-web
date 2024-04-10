package com.anime.animeweb.user;

import com.anime.animeweb.core.EntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends EntityRepository<User> {
}
