package com.anime.animeweb.repositories;

import com.anime.animeweb.model.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends EntityRepository<Role, Long> {
}
