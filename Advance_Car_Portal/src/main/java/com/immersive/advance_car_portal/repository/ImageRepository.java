package com.immersive.advance_car_portal.repository;

import com.immersive.advance_car_portal.entities.Imageentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImageRepository extends JpaRepository<Imageentity,Long> {
    @Query("SELECT i FROM Imageentity i WHERE i.carId = :carId")
    List<Imageentity> getAllColorsByCarId(@Param("car_id") Long carId);
}
