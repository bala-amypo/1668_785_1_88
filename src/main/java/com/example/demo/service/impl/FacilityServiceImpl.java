// src/main/java/com/example/demo/service/impl/FacilityServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.Facility;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.service.FacilityService;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository facilityRepository;
    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");

    public FacilityServiceImpl(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    @Override
    public Facility addFacility(Facility facility) {
        facilityRepository.findByName(facility.getName()).ifPresent(f -> {
            throw new BadRequestException("Facility already exists");
        });

        LocalTime open = LocalTime.parse(facility.getOpenTime(), fmt);
        LocalTime close = LocalTime.parse(facility.getCloseTime(), fmt);
        if (!close.isAfter(open)) {
            throw new BadRequestException("Invalid time range");
        }

        return facilityRepository.save(facility);
    }

    @Override
    public List<Facility> getAllFacilities() {
        return facilityRepository.findAll();
    }
}
// package com.example.demo.service.impl;

// import com.example.demo.exception.ConflictException;
// import com.example.demo.model.Facility;
// import com.example.demo.repository.FacilityRepository;
// import com.example.demo.service.FacilityService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class FacilityServiceImpl implements FacilityService {

//     private final FacilityRepository facilityRepository;

//     public FacilityServiceImpl(FacilityRepository facilityRepository) {
//         this.facilityRepository = facilityRepository;
//     }

//     @Override
//     public Facility addFacility(Facility facility) {
//         facilityRepository.findByName(facility.getName())
//                 .ifPresent(f -> { throw new ConflictException("Facility already exists"); });
//         return facilityRepository.save(facility);
//     }

//     @Override
//     public List<Facility> getAllFacilities() {
//         return facilityRepository.findAll();
//     }
// }
