package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;   
import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.service.BookingService;                

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired BookingRepository used;
    @Override
    public Booking postData3(Booking use){
        return used.save(use);  
    }
   
    @Override
    public List<Booking>getAllData3(){
        return used.findAll();
    }
    @Override
    public String DeleteData3(Long id){
        used.deleteById(id);
        return "Deleted successfully";
    }
    @Override
    public Booking getData3(Long id){
    return used.findById(id).orElse(null);
    }
    @Override
    public Booking updateData3(Long id,Booking entity){
        if(used.existsById(id)){
            entity.setId(id);
            return used.save(entity);
        } 
        return null;
    }
}