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

@Entity
public class Facility {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private String openTime;
    private String closeTime;

    public Facility() {}

    public Facility(Long id, String name, String description, String openTime, String closeTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getOpenTime() { return openTime; }

    public void setId(Long id) { this.id = id; }
}
