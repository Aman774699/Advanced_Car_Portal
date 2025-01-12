package com.immersive.advance_car_portal.controller;

import com.immersive.advance_car_portal.entities.Carsentity;
import com.immersive.advance_car_portal.entities.Imageentity;
import com.immersive.advance_car_portal.services.CarsServices;
import com.immersive.advance_car_portal.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Images")
public class ImageController {
    @Autowired
    ImageService imageService;
    @Autowired
    CarsServices carsServices;

    @PostMapping("/save/{car_id}")
    public ResponseEntity<Imageentity> saveImage(@RequestBody Imageentity imageentity,@PathVariable Long car_id) {
        Optional<Carsentity>car=carsServices.getCarById(car_id);
        if(car.isPresent())
        {
            imageentity.setCarId(car_id);
            imageService.add_image(imageentity);
            return ResponseEntity.ok(imageentity);
        }
        return (ResponseEntity<Imageentity>) ResponseEntity.status(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/get/{car_id}")
    public ResponseEntity<List<Imageentity>> getImages(@PathVariable Long car_id) {
        Optional<Carsentity> carsentity = carsServices.getCarById(car_id);
        if (carsentity.isPresent()) {
            List<Imageentity> imageentity = imageService.getAll_images(car_id);
            return ResponseEntity.ok(imageentity);
        }
        return (ResponseEntity<List<Imageentity>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/get/{car_id}/{image_id}")
    public ResponseEntity<Optional<Imageentity>>getImages(@PathVariable Long car_id, @PathVariable Long image_id)
    {
        Optional<Carsentity> carsentity=carsServices.getCarById(car_id);
        if(carsentity.isPresent())
        {
            Optional<Imageentity> imageentity=imageService.get_image(image_id);
            return ResponseEntity.ok(imageentity);
        }
        return (ResponseEntity<Optional<Imageentity>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/get/{car_id}/{image_id}")
    public ResponseEntity<String>deleteImages(@PathVariable Long car_id, @PathVariable Long image_id)
    {
        Optional<Carsentity> carsentity=carsServices.getCarById(car_id);
        if(carsentity.isPresent())
        {
            imageService.deleteImage(image_id);
            return ResponseEntity.ok("Image Deleted Successfully");
        }
        return ResponseEntity.ok("Car Not Found...");
    }
}

