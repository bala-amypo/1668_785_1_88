// src/main/java/com/example/demo/repository/BookingRepository.java
package com.example.demo.repository;

import com.example.demo.model.Booking;
import com.example.demo.model.Facility;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BookingRepository {
    Booking save(Booking booking);
    Optional<Booking> findById(Long id);

    List<Booking> findByFacilityAndStartTimeLessThanAndEndTimeGreaterThan(
            Facility facility,
            LocalDateTime startTimeLessThan,
            LocalDateTime endTimeGreaterThan
    );
}
// // package com.example.demo.repository;

// // import org.springframework.data.jpa.repository.JpaRepository;
// // import org.springframework.stereotype.Repository;
// // import com.example.demo.model.Booking;

// // @Repository 
// // public interface BookingRepository extends JpaRepository<Booking,Long>{
    
// // }







// // package com.example.demo.repository;

// // import com.example.demo.model.*;
// // import java.time.LocalDateTime;
// // import java.util.*;

// // public interface BookingRepository {
// //     Optional<Booking> findById(Long id);
// //     Booking save(Booking booking);

// //     List<Booking> findByFacilityAndStartTimeLessThanAndEndTimeGreaterThan(
// //             Facility facility,
// //             LocalDateTime end,
// //             LocalDateTime start
// //     );
// // }






// package com.example.demo.repository;

// import com.example.demo.model.Booking;
// import com.example.demo.model.Facility;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import java.time.LocalDateTime;
// import java.util.List;

// @Repository
// public interface BookingRepository extends JpaRepository<Booking, Long> {

//     List<Booking> findByFacilityAndStartTimeLessThanAndEndTimeGreaterThan(
//             Facility facility,
//             LocalDateTime start,
//             LocalDateTime end
//     );
// }
