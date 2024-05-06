package com.anime.animeweb.user;

import com.anime.animeweb.core.EntityController;
import com.anime.animeweb.core.EntityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController extends EntityController<User> {
    public UserController(EntityService<User> service) {
        super(service);
    }
}
