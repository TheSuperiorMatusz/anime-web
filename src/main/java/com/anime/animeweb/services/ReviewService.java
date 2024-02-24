package com.anime.animeweb.services;

import com.anime.animeweb.model.entity.Review;
import com.anime.animeweb.repositories.EntityRepository;

public class ReviewService extends EntityService<Review> {
    public ReviewService(EntityRepository<Review> repository) {
        super(repository);
    }
}
