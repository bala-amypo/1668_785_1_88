// package com.example.demo.controller;

// import java.util.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.model.Booking;
// import com.example.demo.service.BookingService;
// import jakarta.validation.Valid;

// @RequestMapping("/Booking")
// @RestController
// public class BookingController{
//     @Autowired  BookingService ser;
//     @PostMapping("/register")
//     public Booking sendData(@RequestBody Booking stu){
//         return ser.postData3(stu);
//     }
//     @GetMapping("/get")
//     public List<Booking> getval(){
//         return ser.getAllData3();
//     }
//     @DeleteMapping("/delete/{id}")
//     public String del(@PathVariable Long id){
//         return ser.DeleteData3(id);
//     }
//     @GetMapping("/find/{id}")
//     public Booking find(@PathVariable Long id){
//         return ser.getData3(id);
//     }
//     @PutMapping("/put/{id}")
//     public Booking putval(@PathVariable Long id,@RequestBody Booking entity){
//         return ser.updateData3(id,entity);
//     }
// }






package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping("/{userId}/{facilityId}")
    public Booking create(@PathVariable Long userId,
                          @PathVariable Long facilityId,
                          @RequestBody Booking booking) {
        return service.createBooking(userId, facilityId, booking);
    }

    @DeleteMapping("/{id}")
    public Booking cancel(@PathVariable Long id) {
        return service.cancelBooking(id);
    }

    @GetMapping("/{id}")
    public Booking get(@PathVariable Long id) {
        return service.getBooking(id);
    }
}
