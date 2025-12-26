// src/main/java/com/example/demo/service/BookingService.java
package com.example.demo.service;

import com.example.demo.model.Booking;

public interface BookingService {
    Booking createBooking(Long facilityId, Long userId, Booking booking);
    Booking cancelBooking(Long bookingId);
    Booking getBooking(Long bookingId);
}
// // src/main/java/com/example/demo/service/BookingService.java
// package com.example.demo.service;

// import com.example.demo.model.Booking;

// public interface BookingService {
//     Booking createBooking(Long facilityId, Long userId, Booking booking);
//     Booking cancelBooking(Long bookingId);
//     Booking getBooking(Long bookingId);
// }

// // package com.example.demo.service;

// // import java.util.List;
// // import com.example.demo.model.Booking;

// // public interface BookingService{
// //     Booking postData3(Booking use);
// //     List<Booking>getAllData3();
// //     String  DeleteData3(Long id);
// //     Booking getData3(Long id);         
// //     Booking updateData3(Long id,Booking entity);                                                        
// // }



// package com.example.demo.service;

// import com.example.demo.model.Booking;

// public interface BookingService {

//     Booking createBooking(Long facilityId, Long userId, Booking booking);

//     Booking cancelBooking(Long bookingId);

//     Booking getBooking(Long bookingId);
// }
