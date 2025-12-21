package com.example.demo.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;
import jakarta.validation.Valid;

@RequestMapping("/ApartmentUnit")
@RestController
public class ApartmentUnitController{
    @Autowired  ApartmentUnitService ser;
    @PostMapping("/register")
    public ApartmentUnit sendData(@RequestBody ApartmentUnit stu){
        return ser.postData5(stu);
    }
    @GetMapping("/get")
    public List<ApartmentUnit> getval(){
        return ser.getAllData5();
    }
    @DeleteMapping("/delete/{id}")
    public String del(@PathVariable Long id){
        return ser.DeleteData3(id);
    }
    @GetMapping("/find/{id}")
    public Booking find(@PathVariable Long id){
        return ser.getData3(id);
    }
    @PutMapping("/put/{id}")
    public Booking putval(@PathVariable Long id,@RequestBody Booking entity){
        return ser.updateData3(id,entity);
    }
}