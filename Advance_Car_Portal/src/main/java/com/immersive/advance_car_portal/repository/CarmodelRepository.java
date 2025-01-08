package com.immersive.advance_car_portal.repository;

import com.immersive.advance_car_portal.entities.Carmodelsentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarmodelRepository extends JpaRepository<Carmodelsentity,Long> {
}
