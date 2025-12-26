// src/main/java/com/example/demo/repository/BookingLogRepository.java
package com.example.demo.repository;

import com.example.demo.model.Booking;
import com.example.demo.model.BookingLog;
import java.util.List;

public interface BookingLogRepository {
    BookingLog save(BookingLog log);
    List<BookingLog> findByBookingOrderByLoggedAtAsc(Booking booking);
}
// // src/main/java/com/example/demo/repository/BookingLogRepository.java
// package com.example.demo.repository;

// import com.example.demo.model.Booking;
// import com.example.demo.model.BookingLog;
// import java.util.List;

// public interface BookingLogRepository {
//     BookingLog save(BookingLog log);
//     List<BookingLog> findByBookingOrderByLoggedAtAsc(Booking booking);
// }
// package com.example.demo.repository;

// import com.example.demo.model.BookingLog;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import java.util.List;

// @Repository
// public interface BookingLogRepository extends JpaRepository<BookingLog, Long> {

//     // NEW query method
//     List<BookingLog> findAllByBookingIdOrderByCreatedAtAsc(Long bookingId);
// }
