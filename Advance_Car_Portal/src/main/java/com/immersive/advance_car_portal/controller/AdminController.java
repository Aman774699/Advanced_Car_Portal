package com.immersive.advance_car_portal.controller;

import com.immersive.advance_car_portal.DTO.AdminWithDelearshipDTO;
import com.immersive.advance_car_portal.entities.Adminentity;
import com.immersive.advance_car_portal.entities.Dealersentity;
import com.immersive.advance_car_portal.services.Adminservices;
import com.immersive.advance_car_portal.services.Dealerservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
    Adminservices adminservices;
    @Autowired
    Dealerservices dealerservices;

    //    Api for Getting admins info..
    @GetMapping("/get/admins")
    public ResponseEntity<List<Adminentity>> getAdmins() {
        List<Adminentity> adminentities = adminservices.getAlladmin();
        if (adminentities.isEmpty()) {
            ResponseEntity.status(HttpStatus.NOT_FOUND);
        } else {
            ResponseEntity.ok(adminentities);
        }
        return new ResponseEntity<>(adminentities, HttpStatus.OK);
    }

    //    Api for Getting admins information as per perticular user
    @GetMapping("/get/admins/{id}")
    public ResponseEntity<Adminentity> getAdminsbyId(@PathVariable Long id) {
        Optional<Adminentity> adminentities = adminservices.getById(id);
        if (adminentities.isEmpty()) {
            ResponseEntity.status(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(adminentities.get());
        }
        return new ResponseEntity<>(adminentities.get(), HttpStatus.OK);
    }

    //    Api for posting user information algon with dealers
    @PostMapping("/createAdminWithDealership")
    public ResponseEntity<Adminentity> addAdmin(@RequestBody AdminWithDelearshipDTO adminWithDealershipDTO) {
        Adminentity adminentity = new Adminentity();
        adminentity.setName(adminWithDealershipDTO.getName());
        adminentity.setEmail(adminWithDealershipDTO.getEmail());
        adminentity.setPassword(adminWithDealershipDTO.getPassword());
        adminentity.setPhoneNumber(adminWithDealershipDTO.getPhoneNumber());
        adminentity.setRole(adminWithDealershipDTO.getRole());
//        Linking Dealership to admin
//        adminservices.save(adminentity);
        Dealersentity dealersentity = new Dealersentity();
        dealersentity.setAdmin(adminentity);
        dealersentity.setDealershipName(adminWithDealershipDTO.getDealersEntity().getDealershipName());
        dealersentity.setLocation(adminWithDealershipDTO.getDealersEntity().getLocation());
        dealersentity.setRating(adminWithDealershipDTO.getDealersEntity().getRating());
        dealersentity.setContactInfo(adminWithDealershipDTO.getDealersEntity().getContactInfo());
        dealersentity.setAdmin(adminentity);
        adminentity.setDealersentity(dealersentity);
        adminservices.save(adminentity);
        dealerservices.saveDealers(dealersentity);
        return new ResponseEntity<>(adminentity, HttpStatus.CREATED);
    }

    //    Api for updating admins information as per associated Id
    @PutMapping("/createAdminWithDealership")
    public ResponseEntity<Adminentity> updateAdmin(@RequestBody AdminWithDelearshipDTO adminWithDealershipDTO) {
        Adminentity adminentity = new Adminentity();
        adminentity.setName(adminWithDealershipDTO.getName());
        adminentity.setEmail(adminWithDealershipDTO.getEmail());
        adminentity.setPassword(adminWithDealershipDTO.getPassword());
        adminentity.setPhoneNumber(adminWithDealershipDTO.getPhoneNumber());
        adminentity.setRole(adminWithDealershipDTO.getRole());
//        Linking Dealership to admin
//        adminservices.save(adminentity);
        Dealersentity dealersentity = new Dealersentity();
        dealersentity.setAdmin(adminentity);
        dealersentity.setDealershipName(adminWithDealershipDTO.getDealersEntity().getDealershipName());
        dealersentity.setLocation(adminWithDealershipDTO.getDealersEntity().getLocation());
        dealersentity.setRating(adminWithDealershipDTO.getDealersEntity().getRating());
        dealersentity.setContactInfo(adminWithDealershipDTO.getDealersEntity().getContactInfo());
        dealersentity.setAdmin(adminentity);
        adminentity.setDealersentity(dealersentity);
        adminservices.save(adminentity);
        dealerservices.saveDealers(dealersentity);
        return new ResponseEntity<>(adminentity, HttpStatus.CREATED);
    }

    //    Api for Deleting the admin Information
    @DeleteMapping("/delete/admin/{id}")
    public ResponseEntity<Adminentity> deleteAdmin(@PathVariable Long id) {
        adminservices.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
