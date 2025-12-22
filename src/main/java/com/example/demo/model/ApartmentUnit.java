package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String unitNumber;   

    @Min(0)
    @Column(nullable = false)
    private int floor;           

    @OneToOne
    @JoinColumn(name = "owner_id", nullable = false, unique = true)
    private User owner;
}
