// package com.example.demo.controller;

// import java.util.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import com.example.demo.model.Facility;
// import com.example.demo.service.FacilityService;
// import jakarta.validation.Valid;

// @RequestMapping("/Facility")
// @RestController
// public class FacilityController{
//     @Autowired  FacilityService ser;
//     @PostMapping("/register")
//     public Facility sendData(@RequestBody Facility stu){
//         return ser.postData2(stu);
//     }
//     @GetMapping("/get")
//     public List<Facility> getval(){
//         return ser.getAllData2();
//     }
//     @DeleteMapping("/delete/{id}")
//     public String del(@PathVariable Long id){
//         return ser.DeleteData2(id);
//     }
//     @GetMapping("/find/{id}")
//     public Facility find(@PathVariable Long id){
//         return ser.getData2(id);
//     }
//     @PutMapping("/put/{id}")
//     public Facility putval(@PathVariable Long id,@RequestBody Facility entity){
//         return ser.updateData2(id,entity);
//     }
// }




package com.example.demo.controller;

import com.example.demo.model.Facility;
import com.example.demo.service.FacilityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facilities")
public class FacilityController {

    private final FacilityService service;

    public FacilityController(FacilityService service) {
        this.service = service;
    }

    @PostMapping
    public Facility add(@RequestBody Facility f) {
        return service.addFacility(f);
    }

    @GetMapping
    public List<Facility> all() {
        return service.getAllFacilities();
    }
}
