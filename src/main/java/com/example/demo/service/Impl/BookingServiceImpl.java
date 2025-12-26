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


// package com.example.demo.service.impl;

// import com.example.demo.exception.*;
// import com.example.demo.model.*;
// import com.example.demo.repository.*;
// import com.example.demo.service.BookingService;
// import com.example.demo.service.BookingLogService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class BookingServiceImpl implements BookingService {

//     private final BookingRepository bookingRepo;
//     private final FacilityRepository facilityRepo;
//     private final UserRepository userRepo;
//     private final BookingLogService logService;

//     public BookingServiceImpl(BookingRepository bookingRepo,
//                               FacilityRepository facilityRepo,
//                               UserRepository userRepo,
//                               BookingLogService logService) {
//         this.bookingRepo = bookingRepo;
//         this.facilityRepo = facilityRepo;
//         this.userRepo = userRepo;
//         this.logService = logService;
//     }

//     @Override
//     public Booking createBooking(Long facilityId, Long userId, Booking booking) {
//         Facility facility = facilityRepo.findById(facilityId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Facility not found"));

//         User user = userRepo.findById(userId)
//                 .orElseThrow(() -> new ResourceNotFoundException("User not found"));

//         List<Booking> conflicts =
//                 bookingRepo.findByFacilityAndStartTimeLessThanAndEndTimeGreaterThan(
//                         facility, booking.getEndTime(), booking.getStartTime());

//         if (!conflicts.isEmpty()) {
//             throw new ConflictException("Booking conflict");
//         }

//         booking.setFacility(facility);
//         booking.setUser(user);

//         Booking saved = bookingRepo.save(booking);
//         logService.log(saved.getId(), "Booking created");

//         return saved;
//     }

//     @Override
//     public Booking cancelBooking(Long bookingId) {
//         Booking booking = getBooking(bookingId);
//         booking.setStatus(Booking.STATUS_CANCELLED);

//         Booking saved = bookingRepo.save(booking);
//         logService.log(saved.getId(), "Booking cancelled");

//         return saved;
//     }

//     @Override
//     public Booking getBooking(Long bookingId) {
//         return bookingRepo.findById(bookingId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
//     }
// }








@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final FacilityRepository facilityRepository;
    private final UserRepository userRepository;
    private final BookingLogService bookingLogService;

    public BookingServiceImpl(
            BookingRepository bookingRepository,
            FacilityRepository facilityRepository,
            UserRepository userRepository,
            BookingLogService bookingLogService) {

        this.bookingRepository = bookingRepository;
        this.facilityRepository = facilityRepository;
        this.userRepository = userRepository;
        this.bookingLogService = bookingLogService;
    }
}
