package com.immersive.advance_car_portal.services;

import com.immersive.advance_car_portal.entities.Carmodelsentity;
import com.immersive.advance_car_portal.repository.CarmodelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarModelservice {
    @Autowired
    CarmodelRepository carmodelRepository;
    public Carmodelsentity saveCarModel(Carmodelsentity carModel) {
        return carmodelRepository.save(carModel);
    }
    public Carmodelsentity updateCarModel(Carmodelsentity carModel) {
        return carmodelRepository.save(carModel);
    }
    public void deleteCarModel(Carmodelsentity carModel) {
        carmodelRepository.delete(carModel);
    }
    public List<Carmodelsentity> getAllCarModel() {
        return carmodelRepository.findAll();
    }
    public Optional<Carmodelsentity> getCarModelById(long id) {
        return carmodelRepository.findById(id);
    }

}
