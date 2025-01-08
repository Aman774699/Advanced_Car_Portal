package com.immersive.advance_car_portal.repository;

import com.immersive.advance_car_portal.entities.Carsentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<Carsentity, Long> {


}
