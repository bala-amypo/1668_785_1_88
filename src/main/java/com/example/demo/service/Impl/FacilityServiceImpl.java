// package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;   
// import com.example.demo.model.Facility;
// import com.example.demo.repository.FacilityRepository;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.service.FacilityService;                

// @Service
// public class FacilityServiceImpl implements FacilityService{

//     @Autowired FacilityRepository used;
//     @Override
//     public Facility postData2(Facility use){
//         return used.save(use);  
//     }
   
//     @Override
//     public List<Facility>getAllData2(){
//         return used.findAll();
//     }
//     @Override
//     public String DeleteData2(Long id){
//         used.deleteById(id);
//         return "Deleted successfully";
//     }
//     @Override
//     public Facility getData2(Long id){
//     return used.findById(id).orElse(null);
//     }
//     @Override
//     public Facility updateData2(Long id,Facility entity){
//         if(used.existsById(id)){
//             entity.setId(id);
//             return used.save(entity);
//         } 
//         return null;
//     }
// }



package com.example.demo.service.impl;

import com.example.demo.exception.ConflictException;
import com.example.demo.model.Facility;
import com.example.demo.repository.FacilityRepository;
import com.example.demo.service.FacilityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository repo;

    public FacilityServiceImpl(FacilityRepository repo) {
        this.repo = repo;
    }

    @Override
    public Facility addFacility(Facility facility) {
        repo.findByName(facility.getName())
                .ifPresent(f -> { throw new ConflictException("Facility already exists"); });
        return repo.save(facility);
    }

    @Override
    public List<Facility> getAllFacilities() {
        return repo.findAll();
    }
}
