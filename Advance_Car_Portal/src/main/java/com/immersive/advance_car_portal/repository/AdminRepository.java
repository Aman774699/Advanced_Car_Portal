package com.immersive.advance_car_portal.repository;

import com.immersive.advance_car_portal.entities.Adminentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Adminentity, Long> {
}
