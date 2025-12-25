// package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;   
// import com.example.demo.model.BookingLog;
// import com.example.demo.repository.BookingLogRepository;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.service.BookingLogService;                

// @Service
// public class BookingLogServiceImpl implements BookingLogService{

//     @Autowired BookingLogRepository used;
//     @Override
//     public BookingLog postData4(BookingLog use){
//         return used.save(use);  
//     }
   
//     @Override
//     public List<BookingLog>getAllData4(){
//         return used.findAll();
//     }
//     @Override
//     public String DeleteData4(Long id){
//         used.deleteById(id);
//         return "Deleted successfully";
//     }
//     @Override
//     public BookingLog getData4(Long id){
//     return used.findById(id).orElse(null);
//     }
//     @Override
//     public BookingLog updateData4(Long id,BookingLog entity){
//         if(used.existsById(id)){
//             entity.setId(id);
//             return used.save(entity);
//         } 
//         return null;
//     }
// }



package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Booking;
import com.example.demo.model.BookingLog;
import com.example.demo.repository.BookingLogRepository;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingLogServiceImpl implements BookingLogService {

    private final BookingLogRepository logRepo;
    private final BookingRepository bookingRepo;

    public BookingLogServiceImpl(BookingLogRepository logRepo,
                                 BookingRepository bookingRepo) {
        this.logRepo = logRepo;
        this.bookingRepo = bookingRepo;
    }

    @Override
    public void log(Long bookingId, String message) {
        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));

        BookingLog log = new BookingLog();
        log.setBooking(booking);
        log.setLogMessage(message);
        log.setLoggedAt(LocalDateTime.now());

        logRepo.save(log);
    }

    @Override
    public List<BookingLog> getLogsByBooking(Long bookingId) {
        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));

        return logRepo.findByBookingOrderByLoggedAtAsc(booking);
    }
}
