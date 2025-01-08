package com.immersive.advance_car_portal.controller;

import com.immersive.advance_car_portal.entities.Carmodelsentity;
import com.immersive.advance_car_portal.services.CarModelservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/CarModels")
public class CarModelController {
    @Autowired
    CarModelservice carModelservice;

    @PostMapping("/save/carModel")
    public ResponseEntity<Carmodelsentity> saveCarModel(@RequestBody Carmodelsentity carModel) {
        carModel.setCreatedAt(LocalDateTime.now());
        carModel.setUpdatesAt(LocalDateTime.now());
        carModelservice.saveCarModel(carModel);
        return ResponseEntity.ok(carModel);
    }

    @GetMapping("/GetModels")
    public ResponseEntity<List<Carmodelsentity>> getCarModels() {
        return ResponseEntity.ok(carModelservice.getAllCarModel());
    }

    @PatchMapping("/update Model")
    public ResponseEntity<Carmodelsentity> updateCarModel(@RequestBody Carmodelsentity carModel) {
        return ResponseEntity.ok(carModelservice.updateCarModel(carModel));
    }
    @GetMapping("/GetModel/{id}")
    public ResponseEntity<Optional<Carmodelsentity>> getCarModel(@PathVariable long id) {
        return ResponseEntity.ok().body(carModelservice.getCarModelById(id));
    }

    @DeleteMapping("/Delete/Model/{model_id}")
    public ResponseEntity<Carmodelsentity> deleteCarModel(@PathVariable long model_id) {
        Optional<Carmodelsentity> carmodelsentity = carModelservice.getCarModelById(model_id);
        if (carmodelsentity.isPresent()) {
            carModelservice.deleteCarModel(carmodelsentity.get());
            return ResponseEntity.ok().body(carmodelsentity.get());
        }
        return ResponseEntity.notFound().build();
    }
}
