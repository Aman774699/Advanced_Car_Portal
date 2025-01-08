package com.immersive.advance_car_portal.controller;

import com.immersive.advance_car_portal.entities.Carsentity;
import com.immersive.advance_car_portal.entities.Colorsentity;
import com.immersive.advance_car_portal.services.CarsServices;
import com.immersive.advance_car_portal.services.Colorservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Colors")
public class ColorsController {
    @Autowired
    Colorservices colorservices;
    @Autowired
    CarsServices carsServices;

    @PostMapping("/save/colors/{car_id}")
    public ResponseEntity<Colorsentity> saveColors(@RequestBody Colorsentity colorsentity, @PathVariable Long car_id)  {
        Optional<Carsentity> carsentity=carsServices.getCarById(car_id);
        if(carsentity.isPresent()) {
            colorsentity.setCar(carsentity.get());
            colorsentity.setCarVariant(colorsentity.getCarVariant());
            colorservices.saveColor(colorsentity);
            return ResponseEntity.ok(colorsentity);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/colors/{id}")
    public Colorsentity getColors(@PathVariable Long id) {
        return colorservices.getColorById(id);
    }

    @GetMapping("/get/colors/{car_id}")
    public ResponseEntity<List<Colorsentity>> getColorById(@PathVariable Long car_id) {
        Optional<Carsentity> carsentity=carsServices.getCarById(car_id);
        if(carsentity.isPresent()) {
           List<Colorsentity>colorsentityList=colorservices.getAllColors(car_id);
               return ResponseEntity.ok(colorsentityList);
        }
        return ResponseEntity.notFound().build();
    }
}
