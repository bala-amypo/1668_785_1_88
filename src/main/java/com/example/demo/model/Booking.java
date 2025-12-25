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



package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Booking {

    public static final String STATUS_CONFIRMED = "CONFIRMED";
    public static final String STATUS_CANCELLED = "CANCELLED";

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Facility facility;

    @ManyToOne
    private User user;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status = STATUS_CONFIRMED;

    public Booking() {}

    public Booking(Long id, Facility facility, User user,
                   LocalDateTime startTime, LocalDateTime endTime, String status) {
        this.id = id;
        this.facility = facility;
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        if (status != null) this.status = status;
    }

    public Long getId() { return id; }
    public Facility getFacility() { return facility; }
    public User getUser() { return user; }
    public LocalDateTime getStartTime() { return startTime; }
    public String getStatus() { return status; }

    public void setId(Long id) { this.id = id; }
    public void setFacility(Facility facility) { this.facility = facility; }
    public void setUser(User user) { this.user = user; }
    public void setStatus(String status) { this.status = status; }
}
