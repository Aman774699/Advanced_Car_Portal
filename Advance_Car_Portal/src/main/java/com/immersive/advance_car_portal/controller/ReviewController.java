package com.immersive.advance_car_portal.controller;

import com.immersive.advance_car_portal.entities.Carsentity;
import com.immersive.advance_car_portal.entities.Dealersentity;
import com.immersive.advance_car_portal.entities.ReviewsEntity;
import com.immersive.advance_car_portal.services.CarsServices;
import com.immersive.advance_car_portal.services.Dealerservices;
import com.immersive.advance_car_portal.services.ReviewServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Review")
public class ReviewController {
    @Autowired
    ReviewServices reviewServices;
    @Autowired
    CarsServices carsServices;
    @Autowired
    Dealerservices dealerservices;

    @PostMapping("/PostReview/{DealerId}/{CarID}")
    public ResponseEntity<ReviewsEntity> PostReview(@RequestBody ReviewsEntity reviewsEntity, @PathVariable long DealerId, @PathVariable long CarID) {
        Dealersentity dealer = dealerservices.getDealers(DealerId);
        if (dealer != null) {
            reviewsEntity.setDealerId(DealerId);
            Optional<Carsentity> carsentity = carsServices.getCarById(CarID);
            if (carsentity.isPresent()) {
                reviewsEntity.setCar(carsentity.get());
                reviewServices.addReview(reviewsEntity);
                return ResponseEntity.ok(reviewsEntity);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/Delete/{Review_ID}")
    public ResponseEntity<ReviewsEntity> Delete(@PathVariable long Review_ID) {
        ReviewsEntity reviews = reviewServices.getReviewById(Review_ID);
        if (reviews != null) {
            reviewServices.deleteReview(reviews);
            return ResponseEntity.ok(reviews);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/GetReview/{CarId}")
    public ResponseEntity<ReviewsEntity> getReview(@PathVariable long CarId) {
        Optional<Carsentity> carsentity = carsServices.getCarById(CarId);
        if (carsentity.isPresent()) {
            ReviewsEntity reviewsEntity = new ReviewsEntity();
            reviewsEntity.setCar(carsentity.get());
            return ResponseEntity.ok(reviewsEntity);
        }
        return ResponseEntity.notFound().build();
    }
}
