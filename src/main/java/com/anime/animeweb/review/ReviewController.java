package com.anime.animeweb.review;

import com.anime.animeweb.core.EntityController;
import com.anime.animeweb.core.EntityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController extends EntityController<Review> {
    public ReviewController(EntityService<Review> service) {
        super(service);
    }
}
