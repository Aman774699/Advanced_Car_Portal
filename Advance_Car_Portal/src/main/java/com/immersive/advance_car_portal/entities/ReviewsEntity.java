package com.immersive.advance_car_portal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Reviews")
public class ReviewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private Long userId;
    private Long dealerId;
    private Integer rating;
    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    // Many-to-One relationship with Cars
    @ManyToOne
    @JoinColumn(name = "carId", referencedColumnName = "carId")
    @JsonIgnore
    private Carsentity car;
    // Many-to-One relationship with Dealers
    @ManyToOne
    @JoinColumn(name = "dealerId", referencedColumnName = "dealerId",insertable=false, updatable=false)
    @JsonIgnore
    private Dealersentity dealer;
}
