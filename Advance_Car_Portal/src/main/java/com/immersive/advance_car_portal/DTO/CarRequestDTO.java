package com.immersive.advance_car_portal.DTO;

import lombok.Data;

@Data
public class CarRequestDTO {
    private Long dealerId;
    private Long variantId;
    private Long colorId;
    private Double mileage;
    private String description;
    private Double tankCapacity;
    private String bodyType;
    private Integer seatCapacity;
}
