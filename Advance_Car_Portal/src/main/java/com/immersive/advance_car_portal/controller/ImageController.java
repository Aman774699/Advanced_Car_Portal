package com.immersive.advance_car_portal.controller;

import com.immersive.advance_car_portal.entities.Carsentity;
import com.immersive.advance_car_portal.entities.Imageentity;
import com.immersive.advance_car_portal.repository.ImageRepository;
import com.immersive.advance_car_portal.services.CarsServices;
import com.immersive.advance_car_portal.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Images")
public class ImageController {
    @Autowired
    private ImageService imageService;
    @Autowired
    private CarsServices carsServices;
    @PostMapping("/save/Image")
    public ResponseEntity<Imageentity> saveImage(@RequestBody Imageentity image) {
        imageService.add_image(image);
        return ResponseEntity.ok(image);
    }
    @GetMapping("/GetAll/Images/{car_id}")
    public ResponseEntity<List<Imageentity>> getAllImages(@PathVariable Long car_id) {
        List<Imageentity>images=imageService.getAll_images(car_id);
        return ResponseEntity.ok(images);
    }
    @DeleteMapping("Delete/Image/{image_id}")
    public ResponseEntity<Imageentity> deleteImage(@PathVariable Long image_id) {
        Optional<Imageentity> imageentity=imageService.get_image(image_id);
        if(imageentity.isPresent()) {
            imageService.delete_image(imageentity);
            return ResponseEntity.ok(imageentity.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
