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

public class Facility {

    private Long id;
    private String name;
    private String description;
    private String openTime;
    private String closeTime;

    public Facility() {}

    public Facility(Long id, String name, String description,
                    String openTime, String closeTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getOpenTime() { return openTime; }
    public void setOpenTime(String openTime) { this.openTime = openTime; }

    public String getCloseTime() { return closeTime; }
    public void setCloseTime(String closeTime) { this.closeTime = closeTime; }
}
