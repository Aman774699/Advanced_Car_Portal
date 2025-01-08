package com.immersive.advance_car_portal.repository;

import com.immersive.advance_car_portal.entities.ReviewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewsEntity,Long> {
}
