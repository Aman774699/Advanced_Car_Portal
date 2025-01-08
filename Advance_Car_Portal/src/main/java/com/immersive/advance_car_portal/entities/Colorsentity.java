package com.immersive.advance_car_portal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Carscolor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Colorsentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long colorId;
    private String colorCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variantId")
    @JsonIgnore
    private Varientsentity carVariant;
    @ManyToOne
    @JoinColumn(name = "carId",referencedColumnName = "carId")
    @JsonIgnore
    private Carsentity car;
}
