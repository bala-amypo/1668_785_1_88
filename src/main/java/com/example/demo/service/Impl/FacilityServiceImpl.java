package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;   
import com.example.demo.model.Facility;
import com.example.demo.repository.FacilityRepository;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.FacilityService;                

@Service
public class FacilityServiceImpl implements FacilityService{

    @Autowired FacilityRepository used;
    @Override
    public Facility postData1(Facility use){
        return used.save(use);  
    }
   
    @Override
    public List<Facility>getAllData2(){
        return used.findAll();
    }
    @Override
    public String DeleteData2(Long id){
        used.deleteById(id);
        return "Deleted successfully";
    }
    @Override
    public Facility getData2(Long id){
    return used.findById(id).orElse(null);
    }
    @Override
    public User updateData1(Long id,User entity){
        if(used.existsById(id)){
            entity.setId(id);
            return used.save(entity);
        } 
        return null;
    }
}