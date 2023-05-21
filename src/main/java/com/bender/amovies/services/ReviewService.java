package com.bender.amovies.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.bender.amovies.ReviewRepository;
import com.bender.amovies.model.Movie;
import com.bender.amovies.model.Review;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    // first look for the movie by the imdbId, then create review and associate with it
    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(imdbId));

        mongoTemplate.update(Movie.class)
                     .matching(Criteria.where("imdbId").is(imdbId))
                     .apply(new Update().push("reviewIds").value(review))
                     .first();

        return review;
    }    
}
