package com.immersive.advance_car_portal.controller;

import com.immersive.advance_car_portal.entities.Carsentity;
import com.immersive.advance_car_portal.entities.Dealersentity;
import com.immersive.advance_car_portal.services.CarsServices;
import com.immersive.advance_car_portal.services.Dealerservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Cars")
public class CarsController {
    @Autowired
    CarsServices carsServices;
    @Autowired
    Dealerservices dealerservices;

    @PostMapping("/Upload/{id}")
    public ResponseEntity<Carsentity> UploadCars(@RequestBody Carsentity carsentity, @PathVariable long id) {
        Dealersentity dealersentity = dealerservices.getDealers(id);
        if (dealersentity == null) {
            return ResponseEntity.notFound().build();
        } else {
            carsentity.setDealer(dealersentity);
            carsServices.createCar(carsentity);
            return ResponseEntity.ok(carsentity);
        }
    }

    @GetMapping("/FetchbyId/{id}")
    public ResponseEntity<Carsentity> GetCarById(@PathVariable long id) {
        Optional<Carsentity> carsentity = carsServices.getCarById(id);
        if (carsentity.isPresent()) {
            return ResponseEntity.ok(carsentity.get());
        }
        return ResponseEntity.notFound().build();
    }

//    @GetMapping("/FetchByName/{Name}")
//    public List<Carsentity> GetCarByName(@PathVariable String name) {
//        List<Carsentity> carsentity = carsServices.getByName(name);
//        return carsentity;
//    }

    @PostMapping("/updateById/{id}")
    public ResponseEntity<Carsentity> UpdateCar(@RequestBody Carsentity carsentity, @PathVariable long id) {
        Optional<Carsentity> carsentity1 = carsServices.getCarById(id);
        if (carsentity1.isPresent()) {
            carsServices.updateCar(carsentity);
            return ResponseEntity.ok(carsentity);
        } else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/DeleteById/{id}")
    public ResponseEntity<String> DeleteCarById(@PathVariable int id) {
        Optional<Carsentity>carsentity = carsServices.getCarById(id);
        if (carsentity.isPresent()) {
            carsServices.deleteCarById(id);
            return ResponseEntity.ok("Car deleted successfully");
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }
}
