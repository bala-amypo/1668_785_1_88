// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.model.Facility;

// @Repository 
// public interface FacilityRepository extends JpaRepository<Facility,Long>{
    
// }






package com.example.demo.repository;

import com.example.demo.model.Facility;
import java.util.*;

public interface FacilityRepository {
    Optional<Facility> findById(Long id);
    Optional<Facility> findByName(String name);
    Facility save(Facility facility);
    List<Facility> findAll();
}
