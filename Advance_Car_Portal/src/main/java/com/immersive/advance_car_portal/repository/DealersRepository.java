package com.immersive.advance_car_portal.repository;

import com.immersive.advance_car_portal.entities.Dealersentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealersRepository extends JpaRepository<Dealersentity, Long> {
}
