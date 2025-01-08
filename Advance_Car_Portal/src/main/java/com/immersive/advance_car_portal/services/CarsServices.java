package com.immersive.advance_car_portal.services;

import com.immersive.advance_car_portal.entities.Carsentity;
import com.immersive.advance_car_portal.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarsServices {
    @Autowired
    CarsRepository carsRepository;

    public void createCar(Carsentity car) {
        carsRepository.save(car);
    }

    public List<Carsentity> getAllCars() {
        return carsRepository.findAll();
    }

    public Optional<Carsentity> getCarById(long id) {
        return carsRepository.findById(id);
    }

    public void deleteCarById(long id) {
        carsRepository.deleteById(id);
    }

    public void updateCar(Carsentity car) {
        carsRepository.save(car);
    }

//    public List<Carsentity> getByName(String name) {
//        List<Carsentity> cars = carsRepository.findCarByName(name);
//        return cars;
//    }
}

