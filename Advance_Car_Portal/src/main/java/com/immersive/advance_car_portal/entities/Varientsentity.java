package com.immersive.advance_car_portal.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "car_varients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Varientsentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long variantId;
    private String variantName;
    private Double engineSize;
    private String transmission;
    private String fuelType;
    private Double price;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modelId")
    @JsonIgnore
    private Carmodelsentity carModel;
    @OneToMany(mappedBy = "carVariant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Colorsentity> colors;
}
