// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.model.BookingLog;

// public interface BookingLogService{
//     BookingLog postData4(BookingLog use);
//     List<BookingLog>getAllData4();
//     String  DeleteData4(Long id);
//     BookingLog getData4(Long id);         
//     BookingLog updateData4(Long id,BookingLog entity);                                                        
// }


// package com.example.demo.service;

// import com.example.demo.model.BookingLog;

// import java.util.List;

// public interface BookingLogService {

//     void log(Long bookingId, String message);

//     List<BookingLog> getLogsByBooking(Long bookingId);
// }




package com.example.demo.service;

import com.example.demo.model.BookingLog;

import java.util.List;

public interface BookingLogService {

    BookingLog addLog(Long bookingId, String message);

    List<BookingLog> getLogsByBooking(Long bookingId);
}
