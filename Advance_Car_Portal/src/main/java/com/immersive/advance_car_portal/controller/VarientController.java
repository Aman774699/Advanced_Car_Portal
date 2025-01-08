package com.immersive.advance_car_portal.controller;

import com.immersive.advance_car_portal.entities.Carmodelsentity;
import com.immersive.advance_car_portal.entities.Carsentity;
import com.immersive.advance_car_portal.entities.Varientsentity;
import com.immersive.advance_car_portal.services.CarModelservice;
import com.immersive.advance_car_portal.services.CarsServices;
import com.immersive.advance_car_portal.services.Varientservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Varient")
public class VarientController {
    @Autowired
    Varientservices varientservices;
    @Autowired
    CarsServices carsServices;
    @Autowired
    CarModelservice carModelservice;
    @PostMapping("/add-varient/{model_id}")
    public ResponseEntity<Varientsentity> addVarient(@RequestBody Varientsentity varientsentity, @PathVariable("model_id") long model_id) {
        Optional<Carmodelsentity> carmodelsentity=carModelservice.getCarModelById(model_id);
        if (carmodelsentity.isPresent()) {
            varientsentity.setCarModel(carmodelsentity.get());
            varientservices.postVarient(varientsentity);
            return ResponseEntity.ok().body(varientsentity);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getAll_varient/{varient_Id}")
    public ResponseEntity<Varientsentity> getAllVarient(@PathVariable("varient_Id") long varient_Id) {
      Varientsentity varientsentity=varientservices.getVarient(varient_Id);
      if(varientsentity!=null) {
          return ResponseEntity.ok().body(varientsentity);
      }
      return ResponseEntity.notFound().build();
    }
}
