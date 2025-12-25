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

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.BookingLogService;

import java.util.List;

public class BookingLogServiceImpl implements BookingLogService {

    private final BookingLogRepository repo;
    private final BookingRepository bookingRepo;

    public BookingLogServiceImpl(BookingLogRepository r, BookingRepository b) {
        repo = r; bookingRepo = b;
    }

    public BookingLog addLog(Long bookingId, String msg) {
        Booking b = bookingRepo.findById(bookingId).orElseThrow();
        return repo.save(new BookingLog(null, b, msg, null));
    }

    public List<BookingLog> getLogsByBooking(Long bookingId) {
        Booking b = bookingRepo.findById(bookingId).orElseThrow();
        return repo.findByBookingOrderByLoggedAtAsc(b);
    }
}
