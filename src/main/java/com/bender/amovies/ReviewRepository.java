package com.bender.amovies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bender.amovies.model.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
    
}
