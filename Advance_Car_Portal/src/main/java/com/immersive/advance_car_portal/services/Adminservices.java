package com.immersive.advance_car_portal.services;

import com.immersive.advance_car_portal.entities.Adminentity;
import com.immersive.advance_car_portal.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class Adminservices {
    @Autowired
    AdminRepository adminRepository;

    //    Method for getting all the admins
    public List<Adminentity> getAlladmin() {
        return adminRepository.findAll();
    }

    //Method for getting the information of admin for perticular admins
    public Optional<Adminentity> getById(Long Id) {
        return adminRepository.findById(Id);
    }

    //Method for deleting the admin info..
    public ResponseEntity<Adminentity> deleteById(Long Id) {
        Optional<Adminentity> adminentity = adminRepository.findById(Id);
        if (adminentity.isPresent()) {
            adminRepository.deleteById(Id);
        } else {
            ResponseEntity.status(HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(adminentity.get(), HttpStatus.OK);
    }

    //    Method for saving the user information
    public boolean save(Adminentity adminentity) {
        try {
            adminentity.setCreate_At(LocalDateTime.now());
            adminentity.setUpdate_At(LocalDateTime.now());
            adminRepository.save(adminentity);
            return true;
        } catch (Exception e) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
            return false;
        }
    }
}
