package com.anime.animeweb.anime;

import com.anime.animeweb.core.EntityController;
import com.anime.animeweb.core.EntityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/anime")
public class AnimeController extends EntityController<Anime> {
    public AnimeController(EntityService<Anime> service) {
        super(service);
    }
}
