package com.anime.animeweb.repositories;

import com.anime.animeweb.model.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends EntityRepository<User, String> {
}
