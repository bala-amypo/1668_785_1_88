// src/main/java/com/example/demo/repository/FacilityRepository.java
package com.example.demo.repository;

import com.example.demo.model.Facility;
import java.util.List;
import java.util.Optional;

public interface FacilityRepository {
    Optional<Facility> findByName(String name);
    Facility save(Facility facility);
    Optional<Facility> findById(Long id);
    List<Facility> findAll();
}
// // package com.example.demo.repository;

// // import org.springframework.data.jpa.repository.JpaRepository;
// // import org.springframework.stereotype.Repository;
// // import com.example.demo.model.Facility;

// // @Repository 
// // public interface FacilityRepository extends JpaRepository<Facility,Long>{
    
// // }





// package com.example.demo.repository;

// import com.example.demo.model.Facility;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import java.util.Optional;

// @Repository
// public interface FacilityRepository extends JpaRepository<Facility, Long> {
//     Optional<Facility> findByName(String name);
// }
