// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.model.Facility;

// public interface FacilityService{
//     Facility postData2(Facility use);
//     List<Facility>getAllData2();
//     String  DeleteData2(Long id);
//     Facility getData2(Long id);         
//     Facility updateData2(Long id,Facility entity);                                                        
// }



package com.example.demo.service;

import com.example.demo.model.Facility;
import java.util.List;

public interface FacilityService {
    Facility addFacility(Facility facility);
    List<Facility> getAllFacilities();
}
