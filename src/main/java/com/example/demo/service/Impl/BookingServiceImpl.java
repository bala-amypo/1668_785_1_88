// package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;   
// import com.example.demo.model.Booking;
// import com.example.demo.repository.BookingRepository;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.service.BookingService;                

// @Service
// public class BookingServiceImpl implements BookingService{

//     @Autowired BookingRepository used;
//     @Override
//     public Booking postData3(Booking use){
//         return used.save(use);  
//     }
   
//     @Override
//     public List<Booking>getAllData3(){
//         return used.findAll();
//     }
//     @Override
//     public String DeleteData3(Long id){
//         used.deleteById(id);
//         return "Deleted successfully";
//     }
//     @Override
//     public Booking getData3(Long id){
//     return used.findById(id).orElse(null);
//     }
//     @Override
//     public Booking updateData3(Long id,Booking entity){
//         if(used.existsById(id)){
//             entity.setId(id);
//             return used.save(entity);
//         } 
//         return null;
//     }
// }




package com.example.demo.service.impl;

import com.example.demo.exception.ConflictException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;

import java.util.List;

public class BookingServiceImpl implements BookingService {

    private final BookingRepository repo;
    private final FacilityRepository facilityRepo;
    private final UserRepository userRepo;
    private final BookingLogService logService;

    public BookingServiceImpl(BookingRepository r, FacilityRepository f,
                              UserRepository u, BookingLogService l) {
        repo = r; facilityRepo = f; userRepo = u; logService = l;
    }

    public Booking createBooking(Long userId, Long facilityId, Booking b) {
        Facility f = facilityRepo.findById(facilityId).orElseThrow();
        User u = userRepo.findById(userId).orElseThrow();

        List<Booking> conflicts =
                repo.findByFacilityAndStartTimeLessThanAndEndTimeGreaterThan(
                        f, b.getEndTime(), b.getStartTime());

        if (!conflicts.isEmpty())
            throw new ConflictException("Conflict");

        b.setFacility(f);
        b.setUser(u);
        Booking saved = repo.save(b);
        logService.addLog(saved.getId(), "Created");
        return saved;
    }

    public Booking cancelBooking(Long id) {
        Booking b = repo.findById(id).orElseThrow();
        b.setStatus(Booking.STATUS_CANCELLED);
        repo.save(b);
        logService.addLog(id, "Cancelled");
        return b;
    }

    public Booking getBooking(Long id) {
        return repo.findById(id).orElseThrow();
    }
}
