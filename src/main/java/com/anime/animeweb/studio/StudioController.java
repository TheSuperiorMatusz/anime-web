package com.anime.animeweb.studio;

import com.anime.animeweb.core.EntityController;
import com.anime.animeweb.core.EntityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/studio")
public class StudioController extends EntityController<Studio> {
    public StudioController(EntityService<Studio> service) {
        super(service);
    }
}
