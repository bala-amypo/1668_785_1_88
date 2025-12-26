package com.example.demo.service.impl;

import com.example.demo.model.BookingLog;
import com.example.demo.repository.BookingLogRepository;
import com.example.demo.service.BookingLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingLogServiceImpl implements BookingLogService {

    private final BookingLogRepository bookingLogRepository;

    public BookingLogServiceImpl(BookingLogRepository bookingLogRepository) {
        this.bookingLogRepository = bookingLogRepository;
    }

    /**
     * Adds a log entry for a booking
     *
     * @param bookingId ID of the booking
     * @param message   Log message
     */
    @Override
    public void addLog(Long bookingId, String message) {
        BookingLog log = new BookingLog();

        // Set booking reference (assuming BookingLog has a booking field)
        log.setBookingId(bookingId);  // or log.setBooking(booking) if you store full Booking object

        // Set log message
        log.setLogMessage(message);

        // Set timestamp
        log.setCreatedAt(LocalDateTime.now());

        // Save log
        bookingLogRepository.save(log);
    }
}
