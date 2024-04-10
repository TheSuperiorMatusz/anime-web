package com.anime.animeweb.review;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ReviewRepositoryTest {

    @Autowired
    ReviewRepository reviewRepository;

    @Test
    public void shouldPersistsReview() {
        Review newReview = new Review();
        newReview.setContest("Its bad anime");
        Long id = reviewRepository.save(newReview).getIdReview();

        Optional<Review> review = reviewRepository.findById(id);

        Assertions.assertTrue(review.isPresent());
    }

    @Test
    public void shouldReturnList() {
        Review newReview = new Review();
        newReview.setContest("Its bad anime");
        int size = 1;
        reviewRepository.save(newReview);

        List<Review> reviews = (List<Review>) reviewRepository.findAll();

        Assertions.assertEquals(reviews.size(), size);
    }

    @Test
    public void shouldDeleteReview() {
        Review newReview = new Review();
        newReview.setContest("Its bad anime");
        Long id = reviewRepository.save(newReview).getIdReview();

        reviewRepository.deleteById(id);

        Assertions.assertFalse(reviewRepository.existsById(id));
    }
}
