// src/main/java/com/example/demo/repository/ApartmentUnitRepository.java
package com.example.demo.repository;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.model.User;
import java.util.Optional;

public interface ApartmentUnitRepository {
    ApartmentUnit save(ApartmentUnit unit);
    Optional<ApartmentUnit> findByOwner(User owner);
}
// // src/main/java/com/example/demo/repository/ApartmentUnitRepository.java
// package com.example.demo.repository;

// import com.example.demo.model.ApartmentUnit;
// import com.example.demo.model.User;
// import java.util.Optional;

// public interface ApartmentUnitRepository {
//     ApartmentUnit save(ApartmentUnit unit);
//     Optional<ApartmentUnit> findByOwner(User owner);
// }
// // package com.example.demo.repository;

// // import org.springframework.data.jpa.repository.JpaRepository;
// // import org.springframework.stereotype.Repository;
// // import com.example.demo.model.ApartmentUnit;

// // @Repository 
// // public interface ApartmentUnitRepository extends JpaRepository<ApartmentUnit,Long>{
    
// // }






// // package com.example.demo.repository;

// // import com.example.demo.model.ApartmentUnit;
// // import org.springframework.stereotype.Repository;
// // import org.springframework.data.jpa.repository.JpaRepository;
// // import com.example.demo.model.User;
// // import java.util.Optional;

// // @Repository
// // public interface ApartmentUnitRepository extends JpaRepository<ApartmentUnit, Long> {
// //     ApartmentUnit save(ApartmentUnit unit);
// //     Optional<ApartmentUnit> findByOwner(User user);
// // }





// package com.example.demo.repository;

// import com.example.demo.model.ApartmentUnit;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.Optional;

// public interface ApartmentUnitRepository extends JpaRepository<ApartmentUnit, Long> {

//     Optional<ApartmentUnit> findByOwnerId(Long ownerId);
// }
