package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Facility;

public interface FacilityService{
    Facility postData2(Facility use);
    List<Facility>getAllData2();
    String  DeleteData2(Long id);
    User getData2(Long id);         
    User updateData2(Long id,Facility entity);                                                        
}