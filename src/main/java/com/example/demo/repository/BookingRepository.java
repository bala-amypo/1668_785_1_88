// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.model.Booking;

// @Repository 
// public interface BookingRepository extends JpaRepository<Booking,Long>{
    
// }







package com.example.demo.repository;

import com.example.demo.model.*;
import java.time.LocalDateTime;
import java.util.*;

public interface BookingRepository {
    Optional<Booking> findById(Long id);
    Booking save(Booking booking);

    List<Booking> findByFacilityAndStartTimeLessThanAndEndTimeGreaterThan(
            Facility facility,
            LocalDateTime end,
            LocalDateTime start
    );
}
