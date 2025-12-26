// src/main/java/com/example/demo/model/Booking.java
package com.example.demo.model;

import java.time.LocalDateTime;

public class Booking {
    public static final String STATUS_CONFIRMED = "CONFIRMED";
    public static final String STATUS_CANCELLED = "CANCELLED";

    private Long id;
    private Facility facility;
    private User user;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;

    public Booking() {
        this.status = STATUS_CONFIRMED;
    }

    public Booking(Long id, Facility facility, User user,
                   LocalDateTime startTime, LocalDateTime endTime,
                   String status) {
        this.id = id;
        this.facility = facility;
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Facility getFacility() { return facility; }
    public void setFacility(Facility facility) { this.facility = facility; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
// // src/main/java/com/example/demo/model/Booking.java
// package com.example.demo.model;

// import java.time.LocalDateTime;

// public class Booking {
//     public static final String STATUS_CONFIRMED = "CONFIRMED";
//     public static final String STATUS_CANCELLED = "CANCELLED";

//     private Long id;
//     private Facility facility;
//     private User user;
//     private LocalDateTime startTime;
//     private LocalDateTime endTime;
//     private String status;

//     public Booking() {
//         this.status = STATUS_CONFIRMED;
//     }

//     public Booking(Long id, Facility facility, User user,
//                    LocalDateTime startTime, LocalDateTime endTime,
//                    String status) {
//         this.id = id;
//         this.facility = facility;
//         this.user = user;
//         this.startTime = startTime;
//         this.endTime = endTime;
//         this.status = status;
//     }

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public Facility getFacility() { return facility; }
//     public void setFacility(Facility facility) { this.facility = facility; }

//     public User getUser() { return user; }
//     public void setUser(User user) { this.user = user; }

//     public LocalDateTime getStartTime() { return startTime; }
//     public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

//     public LocalDateTime getEndTime() { return endTime; }
//     public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

//     public String getStatus() { return status; }
//     public void setStatus(String status) { this.status = status; }
// }
// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.Data;
// import lombok.NoArgsConstructor;
// import lombok.AllArgsConstructor;
// import lombok.Builder;

// import java.time.LocalDateTime;

// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
// public class Booking {

//     public static final String STATUS_CONFIRMED = "CONFIRMED";
//     public static final String STATUS_CANCELLED = "CANCELLED";

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "facility_id")
//     private Facility facility;

//     @ManyToOne
//     @JoinColumn(name = "user_id")
//     private User user;

//     private LocalDateTime startTime;
//     private LocalDateTime endTime;

//     private String status;
// }
