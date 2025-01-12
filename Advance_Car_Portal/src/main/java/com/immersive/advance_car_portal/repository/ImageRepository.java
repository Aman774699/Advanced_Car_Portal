package com.immersive.advance_car_portal.repository;

import com.immersive.advance_car_portal.entities.Imageentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<Imageentity,Long> {

    List<Imageentity> getAllColorsByCarId(Long carId);
}
