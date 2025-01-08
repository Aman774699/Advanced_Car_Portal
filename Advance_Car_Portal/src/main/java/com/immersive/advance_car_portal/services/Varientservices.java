package com.immersive.advance_car_portal.services;


import com.immersive.advance_car_portal.entities.Varientsentity;
import com.immersive.advance_car_portal.repository.VarientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class Varientservices {
    @Autowired
    VarientRepository varientRepository;

    public Varientsentity postVarient(Varientsentity varient) {
        varient.setCreatedAt(new Date());
        varient.setUpdatedAt(new Date());
        return varientRepository.save(varient);
    }

    public Varientsentity getVarient(long id) {
        Optional<Varientsentity> varientsentity = varientRepository.findById(id);
        return varientsentity.get();
    }

    public List<Varientsentity> getVarients() {
        return varientRepository.findAll();
    }

    public Varientsentity updateVarient(Varientsentity varient) {
        varient.setUpdatedAt(new Date());
        return varientRepository.save(varient);
    }

    public void deleteVarient(long id) {
        varientRepository.deleteById(id);
    }

}
