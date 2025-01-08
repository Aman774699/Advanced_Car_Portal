package com.immersive.advance_car_portal.controller;

import com.immersive.advance_car_portal.DTO.CarRequestDTO;
import com.immersive.advance_car_portal.entities.Carsentity;
import com.immersive.advance_car_portal.entities.Dealersentity;
import com.immersive.advance_car_portal.services.Adminservices;
import com.immersive.advance_car_portal.services.CarsServices;
import com.immersive.advance_car_portal.services.Dealerservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Dealers")
public class DealersController {
    @Autowired
    Dealerservices dealerservices;
    @Autowired
    Adminservices adminservices;
    @Autowired
    CarsServices carsServices;

    //    Api for Getting the Dealers Information
    @GetMapping("/Get/Dealers/{id}")
    public ResponseEntity<Dealersentity> getDealer(@PathVariable int id) {
        Dealersentity dealersentity = dealerservices.getDealers(id);
        if (dealersentity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dealersentity);
    }

    //    Api for getting all the dealers
    @GetMapping("/Getall/Dealers")
    public ResponseEntity<List<Dealersentity>> getAllDealers() {
        List<Dealersentity> dealersentity = dealerservices.getAllDealers();
        return ResponseEntity.ok(dealersentity);
    }

    //    Api for deleting the dealers Information
    @DeleteMapping("/Delete/Dealer/{id}")
    public ResponseEntity<String> deleteDealer(@PathVariable long id) {
        Dealersentity dealersentity = dealerservices.getDealers(id);
        if (dealersentity == null) {
            return ResponseEntity.notFound().build();
        }
        dealerservices.deleteDealers(id);
        return ResponseEntity.ok("Dealer deleted");
    }

    //    Api for updating the dealers information
    @PostMapping("/Update/Dealersinfo")
    public ResponseEntity<String> updateDealer(@RequestBody Dealersentity dealersentity) {
        dealerservices.saveDealers(dealersentity);
        return ResponseEntity.ok("Dealer updated");
    }

    @PostMapping("/Upload/cars/info/{id}")
    public ResponseEntity<List<Carsentity>> uploadCars(@PathVariable long id, @RequestBody Dealersentity dealersentity, CarRequestDTO carRequestDTO) {
        Dealersentity dealersentity1 = dealerservices.getDealers(id);
        if (dealersentity1 == null) {
            return ResponseEntity.notFound().build();
        }
        Carsentity carsentity = new Carsentity();
        List<Carsentity> carsentitiesList = dealersentity.getCars();
        for (Carsentity carsentity1 : carsentitiesList) {
            carRequestDTO.setDealerId(id);
            carRequestDTO.setMileage(carsentity1.getMileage());
            carRequestDTO.setDescription(carsentity1.getDescription());
            carRequestDTO.setColorId(carsentity1.getColorId());
            carRequestDTO.setSeatCapacity(carsentity1.getSeatCapacity());
            carRequestDTO.setBodyType(carsentity1.getBodyType());
            carRequestDTO.setTankCapacity(carsentity1.getTankCapacity());
            carRequestDTO.setVariantId(carsentity1.getVariantId());
          carsServices.createCar(carsentity1);
        }
     return ResponseEntity.ok(carsentitiesList);
    }
}
