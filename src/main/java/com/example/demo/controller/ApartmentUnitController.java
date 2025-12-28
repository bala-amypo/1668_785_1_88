package com.example.demo.controller;

import com.example.demo.model.ApartmentUnit;
import com.example.demo.service.ApartmentUnitService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
@RequestMapping("/units")
@SecurityRequirement(name = "bearerAuth")

public class ApartmentUnitController {

    private final ApartmentUnitService service;

    public ApartmentUnitController(ApartmentUnitService service) {
        this.service = service;
    }

    @PostMapping("/assign/{userId}")
    public ApartmentUnit assign(@PathVariable Long userId,
                                @RequestBody ApartmentUnit unit) {
        return service.assignUnitToUser(userId, unit);
    }

    @GetMapping("/user/{userId}")
    public ApartmentUnit get(@PathVariable Long userId) {
        return service.getUnitByUser(userId);
    }
}