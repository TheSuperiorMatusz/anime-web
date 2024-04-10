package com.anime.animeweb.review;

import com.anime.animeweb.core.EntityService;
import com.anime.animeweb.review.Review;
import com.anime.animeweb.core.EntityRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService extends EntityService<Review> {
    public ReviewService(EntityRepository<Review> repository) {
        super(repository);
    }
}
