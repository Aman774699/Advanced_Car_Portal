package com.immersive.advance_car_portal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

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
    @JsonIgnore
    private Carsentity car;
}
