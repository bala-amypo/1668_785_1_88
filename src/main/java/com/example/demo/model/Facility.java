// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.Data;
// import lombok.NoArgsConstructor;
// import lombok.AllArgsConstructor;
// import lombok.Builder;

// import java.util.List;

// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class Facility {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true)
//     private String name;

//     private String description;

//     @OneToMany(mappedBy = "facility")
//     private List<Booking> bookings;
// }
