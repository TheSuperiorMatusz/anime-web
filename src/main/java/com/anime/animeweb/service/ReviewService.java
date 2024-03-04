package com.anime.animeweb.service;

import com.anime.animeweb.model.entity.Review;
import com.anime.animeweb.repository.EntityRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService extends EntityService<Review> {
    public ReviewService(EntityRepository<Review> repository) {
        super(repository);
    }
}
