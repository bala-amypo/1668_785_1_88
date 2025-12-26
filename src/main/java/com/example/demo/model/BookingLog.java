// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.*;

// import java.time.LocalDateTime;

// @Entity
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class BookingLog {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "booking_id", nullable = false)
//     private Booking booking;

//     @Column(nullable = false)
//     private String logMessage;

//     @Column(nullable = false, updatable = false)
//     private LocalDateTime loggedAt;

//     @PrePersist
//     protected void onCreate() {
//         this.loggedAt = LocalDateTime.now();
//     }
// }


package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "booking_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="booking_id", nullable=false)
    private Booking booking;

    private String logMessage;

    private LocalDateTime loggedAt;

    @PrePersist
    public void onCreate() {
        this.loggedAt = LocalDateTime.now();
    }
}
