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
import java.time.LocalDateTime;

@Entity
public class BookingLog {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Booking booking;

    private String logMessage;
    private LocalDateTime loggedAt;

    public BookingLog() {}

    public BookingLog(Long id, Booking booking, String logMessage, LocalDateTime loggedAt) {
        this.id = id;
        this.booking = booking;
        this.logMessage = logMessage;
        this.loggedAt = loggedAt;
    }

    @PrePersist
    public void onCreate() {
        loggedAt = LocalDateTime.now();
    }

    public Booking getBooking() { return booking; }
    public String getLogMessage() { return logMessage; }
    public LocalDateTime getLoggedAt() { return loggedAt; }

    public void setLogMessage(String msg) { this.logMessage = msg; }
}
