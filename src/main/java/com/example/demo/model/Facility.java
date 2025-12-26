// package com.example.demo.model;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.NotBlank;
// import lombok.*;

// import java.time.LocalTime;

// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class Facility {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @NotBlank
//     @Column(nullable = false)
//     private String name;

//     private String description;

//     @Column(nullable = false)
//     private LocalTime openTime;  

//     @Column(nullable = false)
//     private LocalTime closeTime; 
// }




package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "facilities")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    private String openTime;

    private String closeTime;
}
