package com.immersive.advance_car_portal.DTO;

import lombok.Data;

@Data
public class ReviewRequestDTO {
    private Long carId;
    private Long dealerId;
    private Long userId;
    private Integer rating;
    private String comment;
}
