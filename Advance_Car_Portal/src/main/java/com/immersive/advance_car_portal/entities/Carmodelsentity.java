package com.immersive.advance_car_portal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "car_models")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Carmodelsentity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long modelId;
    private String brand;
    private String ModelName;
    private LocalDateTime createdAt;
    private LocalDateTime updatesAt;
    @JsonIgnore
    @OneToMany(mappedBy = "carModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Varientsentity>varients;
}
