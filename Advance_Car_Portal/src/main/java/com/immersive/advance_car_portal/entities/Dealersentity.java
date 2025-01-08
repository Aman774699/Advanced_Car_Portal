package com.immersive.advance_car_portal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "dealers")
@Data
public class Dealersentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long dealerId;
    @OneToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    @JsonIgnore
    private Adminentity admin;
    private String dealershipName;
    private String location;
    private String contactInfo;
    private Double rating;

    @OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Carsentity> cars;
    // One-to-Many relationship with Reviews
    @OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ReviewsEntity> reviews;
}
