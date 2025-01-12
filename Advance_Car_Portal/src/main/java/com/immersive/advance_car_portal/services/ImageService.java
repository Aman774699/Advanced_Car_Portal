package com.immersive.advance_car_portal.services;

import com.immersive.advance_car_portal.entities.Carsentity;
import com.immersive.advance_car_portal.entities.Imageentity;
import com.immersive.advance_car_portal.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    CarsServices carsServices;

    public Imageentity add_image(Imageentity imageentity) {
        imageentity.setUploadAt(new Date());
        return imageRepository.save(imageentity);
    }

    public Imageentity update_image(Imageentity imageentity) {
        return imageRepository.save(imageentity);
    }

    //    public Imageentity delete_image(long image_id) {
//        Optional<Imageentity>imageentity=imageRepository.findById(image_id);
//        if(imageentity.isPresent())
//        {
//            imageRepository.delete(imageentity);
//            return imageentity;
//        }
//        return null;
//    }
    public Optional<Imageentity> get_image(Long image_id) {
        return imageRepository.findById(image_id);
    }
    public List<Imageentity> getAll_images(Long car_id) {
        Optional<Carsentity> carsentity = carsServices.getCarById(car_id);
        if (carsentity.isPresent()) {
            List<Imageentity> imageList = imageRepository.getAllColorsByCarId(car_id);
            return imageList;
        } else {
            return null;
        }
    }

    public void deleteImage(Long imageId) {
      Optional<Imageentity>imageentity = imageRepository.findById(imageId);
     if( imageentity.isPresent()){
          imageRepository.deleteById(imageId);
        }
    }
}
