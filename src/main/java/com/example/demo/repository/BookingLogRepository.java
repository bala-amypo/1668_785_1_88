// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.model.BookingLog;

// @Repository 
// public interface BookingLogRepository extends JpaRepository<BookingLog,Long>{
    
// }







package com.example.demo.repository;

import com.example.demo.model.*;
import java.util.List;

public interface BookingLogRepository {
    BookingLog save(BookingLog log);
    List<BookingLog> findByBookingOrderByLoggedAtAsc(Booking booking);
}
