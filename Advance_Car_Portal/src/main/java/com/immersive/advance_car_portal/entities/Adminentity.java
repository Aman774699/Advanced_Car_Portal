package com.immersive.advance_car_portal.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Adminentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String email;
    private String password;
    private Long phoneNumber;
    private  String role;  //customer,delar,admin
    private LocalDateTime Create_At;
    private LocalDateTime Update_At;
    @OneToOne(mappedBy = "admin",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Dealersentity dealersentity;
}
