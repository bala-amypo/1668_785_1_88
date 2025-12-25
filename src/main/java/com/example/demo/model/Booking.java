// package com.example.demo.model;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.NotNull;
// import lombok.*;

// import java.time.LocalDateTime;

// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class Booking {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

  
//     @ManyToOne
//     @JoinColumn(name = "facility_id", nullable = false)
//     private Facility facility;

   
//     @ManyToOne
//     @JoinColumn(name = "user_id", nullable = false)
//     private User user;

//     @Column(nullable = false)
//     private LocalDateTime startTime;

//     @Column(nullable = false)
//     private LocalDateTime endTime;

//     @Column(nullable = false)
//     private String status = "CONFIRMED"; 
// }


