package com.anime.animeweb.service;


import com.anime.animeweb.model.entity.Review;
import com.anime.animeweb.repository.ReviewRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReviewServiceTest {
    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewService reviewService;

    @Test
    public void shouldFindAllReviews() {
        List<Review> reviewList = new ArrayList<>(List.of(new Review(), new Review()));
        int sizeOfReviewList = reviewList.size();
        Mockito.when(reviewRepository.findAll()).thenReturn(reviewList);

        List<Review> reviewsFromService = reviewService.findAllEntities();

        Assertions.assertEquals(sizeOfReviewList, reviewsFromService.size());
    }

    @Test
    public void shouldFindReview() throws ChangeSetPersister.NotFoundException {
        Long idReviewToFind = 1L;
        Review review = new Review();
        review.setContest("Ninja Kamuis is brillant");
        Mockito.when(reviewRepository.findById(idReviewToFind)).thenReturn(Optional.of(review));

        Review reviewFromService = reviewService.findById(idReviewToFind);

        Assertions.assertEquals(review.getContest(), reviewFromService.getContest());

    }

    @Test
    public void shouldDeleteReviewWithGivenId() {
        Long reviewId = 2L;
        reviewService.deleteEntityFromDatabase(reviewId);
        verify(reviewRepository).deleteById(reviewId);
    }

    @Test
    public void shouldAddReview() {
        Review review = new Review();
        review.setContest("Jujutsu Kaisen is an amazing anime to watch");
        Mockito.when(reviewRepository.save(review)).thenReturn(review);

        Review reviewFromService = reviewService.addEntityToDatabase(review);

        Assertions.assertEquals(review.getContest(), reviewFromService.getContest());
    }
}
