// package com.example.demo.model;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.Min;
// import lombok.*;

// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class ApartmentUnit {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false, unique = true)
//     private String unitNumber;   

//     @Min(0)
//     @Column(nullable = false)
//     private int floor;           

//     @OneToOne
//     @JoinColumn(name = "owner_id", nullable = false, unique = true)
//     private User owner;
// }



package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class ApartmentUnit {

    @Id
    @GeneratedValue
    private Long id;

    private String unitNumber;
    private int floor;

    @OneToOne
    private User owner;

    public ApartmentUnit() {}

    public ApartmentUnit(Long id, String unitNumber, int floor, User owner) {
        this.id = id;
        this.unitNumber = unitNumber;
        this.floor = floor;
        this.owner = owner;
    }

    public void setId(Long id) { this.id = id; }
    public User getOwner() { return owner; }
    public String getUnitNumber() { return unitNumber; }

    public void setOwner(User owner) { this.owner = owner; }
}
