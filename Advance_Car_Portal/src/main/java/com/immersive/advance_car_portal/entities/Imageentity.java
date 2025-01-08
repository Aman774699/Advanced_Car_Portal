package com.immersive.advance_car_portal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Imageentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ImageId;
    private Long carId;
    private String imageUrl;
    @Temporal(TemporalType.TIMESTAMP)
    private Date UploadAt;
    @ManyToOne
    @JoinColumn(name = "carId", referencedColumnName = "carId",insertable=false, updatable=false)
    private Carsentity car;
}
