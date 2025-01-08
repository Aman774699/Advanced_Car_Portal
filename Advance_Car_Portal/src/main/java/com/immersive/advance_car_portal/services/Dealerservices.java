package com.immersive.advance_car_portal.services;

import com.immersive.advance_car_portal.entities.Dealersentity;
import com.immersive.advance_car_portal.repository.DealersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Dealerservices {
    @Autowired
    DealersRepository dealersRepository;

    //    Method for Saving dealers Information
    public Dealersentity saveDealers(Dealersentity dealersentity) {
        dealersRepository.save(dealersentity);
        return dealersentity;
    }

    //     Method for Reteriving Particular Dealers Information
    public Dealersentity getDealers(long dealerid) {
        Optional<Dealersentity> dealersentity = dealersRepository.findById(dealerid);
        return dealersentity.get();
    }

    // Method for Reteriving All Dealers Information
    public List<Dealersentity> getAllDealers() {
        return dealersRepository.findAll();
    }

    // Mehtod for deleting the Dealers info..
    public void deleteDealers(long dealerid) {
        dealersRepository.deleteById(dealerid);
    }

    //    Method for Updating the dealers information
    public Dealersentity updateDealers(Dealersentity dealersentity) {
        return dealersRepository.save(dealersentity);
    }


}
