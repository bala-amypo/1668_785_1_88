// src/main/java/com/example/demo/service/impl/BookingLogServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.model.Booking;
import com.example.demo.model.BookingLog;
import com.example.demo.repository.BookingLogRepository;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingLogService;

import java.time.LocalDateTime;
import java.util.List;

public class BookingLogServiceImpl implements BookingLogService {

    private final BookingLogRepository bookingLogRepository;
    private final BookingRepository bookingRepository;

    public BookingLogServiceImpl(BookingLogRepository bookingLogRepository,
                                 BookingRepository bookingRepository) {
        this.bookingLogRepository = bookingLogRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public BookingLog addLog(Long bookingId, String message) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow();
        BookingLog log = new BookingLog();
        log.setBooking(booking);
        log.setLogMessage(message);
        log.setLoggedAt(LocalDateTime.now());
        return bookingLogRepository.save(log);
    }

    @Override
    public List<BookingLog> getLogsByBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow();
        return bookingLogRepository.findByBookingOrderByLoggedAtAsc(booking);
    }
}
// // src/main/java/com/example/demo/service/impl/BookingLogServiceImpl.java
// package com.example.demo.service.impl;

// import com.example.demo.model.Booking;
// import com.example.demo.model.BookingLog;
// import com.example.demo.repository.BookingLogRepository;
// import com.example.demo.repository.BookingRepository;
// import com.example.demo.service.BookingLogService;

// import java.time.LocalDateTime;
// import java.util.List;

// public class BookingLogServiceImpl implements BookingLogService {

//     private final BookingLogRepository bookingLogRepository;
//     private final BookingRepository bookingRepository;

//     public BookingLogServiceImpl(BookingLogRepository bookingLogRepository,
//                                  BookingRepository bookingRepository) {
//         this.bookingLogRepository = bookingLogRepository;
//         this.bookingRepository = bookingRepository;
//     }

//     @Override
//     public BookingLog addLog(Long bookingId, String message) {
//         Booking booking = bookingRepository.findById(bookingId).orElseThrow();
//         BookingLog log = new BookingLog();
//         log.setBooking(booking);
//         log.setLogMessage(message);
//         log.setLoggedAt(LocalDateTime.now());
//         return bookingLogRepository.save(log);
//     }

//     @Override
//     public List<BookingLog> getLogsByBooking(Long bookingId) {
//         Booking booking = bookingRepository.findById(bookingId).orElseThrow();
//         return bookingLogRepository.findByBookingOrderByLoggedAtAsc(booking);
//     }
// }

// package com.example.demo.service.impl;

// import com.example.demo.model.BookingLog;
// import com.example.demo.repository.BookingLogRepository;
// import com.example.demo.service.BookingLogService;
// import org.springframework.stereotype.Service;

// import java.time.LocalDateTime;
// import java.util.List;

// @Service
// public class BookingLogServiceImpl implements BookingLogService {

//     private final BookingLogRepository bookingLogRepository;

//     public BookingLogServiceImpl(BookingLogRepository bookingLogRepository) {
//         this.bookingLogRepository = bookingLogRepository;
//     }

//     @Override
//     public void addLog(Long bookingId, String message) {
//         BookingLog log = new BookingLog();
//         log.setBookingId(bookingId);
//         log.setLogMessage(message);
//         log.setCreatedAt(LocalDateTime.now());
//         bookingLogRepository.save(log);
//     }

//     @Override
//     public List<BookingLog> getLogsByBooking(Long bookingId) {
//         return bookingLogRepository.findAllByBookingIdOrderByCreatedAtAsc(bookingId);
//     }
// }
