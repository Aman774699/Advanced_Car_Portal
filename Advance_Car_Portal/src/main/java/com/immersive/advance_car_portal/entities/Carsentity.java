package com.immersive.advance_car_portal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Carsentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;
    @ManyToOne
    @JoinColumn(name = "dealerId", referencedColumnName = "dealerId")
    @JsonBackReference
    private Dealersentity dealer;
    private Long variantId;
    private Long colorId;
    private Double mileage;
    private String description;
    private Double tankCapacity;
    private String bodyType;
    private Integer seatCapacity;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    //    Many to one mapping with varient
    @ManyToOne
    @JoinColumn(name = "variantId", referencedColumnName = "variantId", insertable = false, updatable = false)
    @JsonBackReference
    private Varientsentity variant;
    //    One to Many Mapping with images
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Imageentity> images;
    // One-to-Many relationship with Reviews
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReviewsEntity> reviews;
}
