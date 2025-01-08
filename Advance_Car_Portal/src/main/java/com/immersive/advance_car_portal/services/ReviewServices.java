package com.immersive.advance_car_portal.services;

import com.immersive.advance_car_portal.entities.ReviewsEntity;
import com.immersive.advance_car_portal.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServices {
    @Autowired
    private ReviewRepository reviewRepository;
    public ReviewsEntity addReview(ReviewsEntity review) {
        review.setCreatedAt(new Date());
        review.setUpdatedAt(new Date());
        return reviewRepository.save(review);
    }
    public List<ReviewsEntity> getAllReviews() {
        return reviewRepository.findAll();
    }
    public ReviewsEntity getReviewById(long id) {
        Optional<ReviewsEntity> review = reviewRepository.findById(id);
        return review.orElse(null);
    }
    public ReviewsEntity deleteReview(ReviewsEntity review) {
        reviewRepository.delete(review);
        return review;
    }
}
