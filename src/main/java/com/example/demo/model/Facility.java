// src/main/java/com/example/demo/model/Facility.java
package com.example.demo.model;

public class Facility {
    private Long id;
    private String name;
    private String description;
    private String openTime;   // HH:mm
    private String closeTime;  // HH:mm

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
// // src/main/java/com/example/demo/model/Facility.java
// package com.example.demo.model;

// public class Facility {
//     private Long id;
//     private String name;
//     private String description;
//     private String openTime;   // HH:mm
//     private String closeTime;  // HH:mm

//     public Facility() {}

//     public Facility(Long id, String name, String description,
//                     String openTime, String closeTime) {
//         this.id = id;
//         this.name = name;
//         this.description = description;
//         this.openTime = openTime;
//         this.closeTime = closeTime;
//     }

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getName() { return name; }
//     public void setName(String name) { this.name = name; }

//     public String getDescription() { return description; }
//     public void setDescription(String description) { this.description = description; }

//     public String getOpenTime() { return openTime; }
//     public void setOpenTime(String openTime) { this.openTime = openTime; }

//     public String getCloseTime() { return closeTime; }
//     public void setCloseTime(String closeTime) { this.closeTime = closeTime; }
// }
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
