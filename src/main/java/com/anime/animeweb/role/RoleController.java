package com.anime.animeweb.role;

import com.anime.animeweb.core.EntityController;
import com.anime.animeweb.core.EntityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController extends EntityController<Role> {
    public RoleController(EntityService<Role> service) {
        super(service);
    }
}
