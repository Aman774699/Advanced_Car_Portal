package com.immersive.advance_car_portal.services;

import com.immersive.advance_car_portal.entities.Colorsentity;
import com.immersive.advance_car_portal.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class Colorservices {
    @Autowired
    ColorRepository colorRepository;

    public Colorsentity saveColor(Colorsentity color) {
        colorRepository.save(color);
        return color;
    }

    public Colorsentity deleteColor(Colorsentity color) {
        colorRepository.delete(color);
        return color;
    }

    public List<Colorsentity> getAllColors(Long id) {
        List<Colorsentity> colorsentityList = colorRepository.findAll();
        System.out.println(colorsentityList);
        return colorsentityList.stream()
                .filter(x -> x.getCar().getCarId().equals(id))
                .toList();
    }


    public Colorsentity getColorById(long id) {
        Optional<Colorsentity> colorsentity = colorRepository.findById(id);
        if (colorsentity.isPresent())
            return colorsentity.get();
        return null;
    }
}
