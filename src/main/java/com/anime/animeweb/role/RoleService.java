package com.anime.animeweb.role;

import com.anime.animeweb.core.EntityService;
import com.anime.animeweb.role.Role;
import com.anime.animeweb.core.EntityRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends EntityService<Role> {
    public RoleService(EntityRepository<Role> repository) {
        super(repository);
    }
}
