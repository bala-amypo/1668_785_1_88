// package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;   
// import com.example.demo.model.ApartmentUnit;
// import com.example.demo.repository.ApartmentUnitRepository;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.service.ApartmentUnitService;                

// @Service
// public class ApartmentUnitServiceImpl implements ApartmentUnitService{

//     @Autowired ApartmentUnitRepository used;
//     @Override
//     public ApartmentUnit postData5(ApartmentUnit use){
//         return used.save(use);  
//     }
   
//     @Override
//     public List<ApartmentUnit>getAllData5(){
//         return used.findAll();
//     }
//     @Override
//     public String DeleteData5(Long id){
//         used.deleteById(id);
//         return "Deleted successfully";
//     }
//     @Override
//     public ApartmentUnit getData5(Long id){
//     return used.findById(id).orElse(null);
//     }
//     @Override
//     public ApartmentUnit updateData5(Long id,ApartmentUnit entity){
//         if(used.existsById(id)){
//             entity.setId(id);
//             return used.save(entity);
//         } 
//         return null;
//     }
// }



package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ApartmentUnitService;

public class ApartmentUnitServiceImpl implements ApartmentUnitService {

    private final ApartmentUnitRepository repo;
    private final UserRepository userRepo;

    public ApartmentUnitServiceImpl(ApartmentUnitRepository r, UserRepository u) {
        this.repo = r;
        this.userRepo = u;
    }

    public ApartmentUnit assignUnitToUser(Long userId, ApartmentUnit unit) {
        User user = userRepo.findById(userId).orElseThrow();
        unit.setOwner(user);
        ApartmentUnit saved = repo.save(unit);
        user.setApartmentUnit(saved);
        return saved;
    }

    public ApartmentUnit getUnitByUser(Long userId) {
        User u = userRepo.findById(userId).orElseThrow();
        return repo.findByOwner(u).orElseThrow();
    }
}
