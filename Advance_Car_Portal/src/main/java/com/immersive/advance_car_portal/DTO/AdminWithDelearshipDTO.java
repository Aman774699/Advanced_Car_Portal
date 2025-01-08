package com.immersive.advance_car_portal.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class AdminWithDelearshipDTO {
    // Admin related fields
    private String name;
    private String email;
    private String password;
    private Long phoneNumber;
    private String role;  // "admin", "dealer", etc.
    private DealershipDTO dealersEntity;

    // Inner DTO for the Dealership details
    @Setter
    @Getter
    public static class DealershipDTO {
        private String dealershipName;
        private String location;
        private String contactInfo;
        private Double rating;
        private List<String> cars; // Or you can use List of CarsEntity DTOs if needed
        private List<String> reviews; // Or use List of ReviewEntity DTOs if needed
    }

}
