package com.anime.animeweb.review;


import com.anime.animeweb.configuration.SecurityConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@AutoConfigureJsonTesters
@WebMvcTest(ReviewController.class)
@Import(SecurityConfiguration.class)
public class ReviewControllerMockWithContextTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReviewService reviewService;

    @Autowired
    private JacksonTester<Review> reviewJacksonTester;

    @Autowired
    private JacksonTester<List<Review>> listJacksonTester;

    private final static String URL_REVIEWS = "/api/v1/reviews";

    @Test
    public void canRetrieveAllReviews() throws Exception {
        Review review = new Review();
        review.setContest("Test Contest");
        List<Review> reviews = List.of(review);
        when(reviewService.findAllEntities()).thenReturn(reviews);

        MockHttpServletResponse response = mockMvc.perform(get(URL_REVIEWS)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();


        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(listJacksonTester.write(reviews).getJson());
    }

    @Test
    public void canRetrieveReviewById() throws Exception {
        Long reviewId = 1L;
        Review review = new Review();
        review.setContest("Test Contest");
        review.setIdReview(reviewId);
        when(reviewService.findById(reviewId)).thenReturn(review);

        MockHttpServletResponse response = mockMvc.perform(get(URL_REVIEWS + "/" + reviewId)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(reviewJacksonTester.write(review).getJson());
    }

    @Test
    public void canCreateReview() throws Exception {
        Review review = new Review();
        review.setContest("Test Contest");

        when(reviewService.addEntityToDatabase(review)).thenReturn(review);

        MockHttpServletResponse response = mockMvc.perform(post(URL_REVIEWS)
                        .contentType(MediaType.APPLICATION_JSON).content(reviewJacksonTester.write(review).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    }

    @Test
    public void canDeleteReview() throws Exception {
        Long reviewId = 1L;
        Review review = new Review();
        review.setContest("Test Contest");
        review.setIdReview(reviewId);
        when(reviewService.findById(reviewId)).thenReturn(review);

        MockHttpServletResponse response = mockMvc.perform(delete(URL_REVIEWS + "/" + reviewId)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();


        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}
