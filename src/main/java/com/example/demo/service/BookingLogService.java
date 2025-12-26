// src/main/java/com/example/demo/service/BookingLogService.java
package com.example.demo.service;

import com.example.demo.model.BookingLog;
import java.util.List;

public interface BookingLogService {
    BookingLog addLog(Long bookingId, String message);
    List<BookingLog> getLogsByBooking(Long bookingId);
}


// package com.example.demo.service;

// import com.example.demo.model.BookingLog;
// import java.util.List;

// public interface BookingLogService {
//     void addLog(Long bookingId, String message);

//     // NEW method
//     List<BookingLog> getLogsByBooking(Long bookingId);
// }
