package com.example.demo.controller;

import com.example.demo.model.Facility;
import com.example.demo.service.FacilityService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


import java.util.List;

@RestController
@RequestMapping("/facilities")
@SecurityRequirement(name = "bearerAuth")

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