package com.example.demo.controller;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserService userService,
                          AuthenticationManager authenticationManager,
                          JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest req) {
        User u = new User(null, req.getName(), req.getEmail(), req.getPassword(), "RESIDENT");
        User saved = userService.register(u);
        return ResponseEntity.status(201).body(saved);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody RegisterRequest req) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
        );

        // In a real app, fetch user from DB to get id/role
        String email = req.getEmail();
        Long userId = 1L;        // TODO: replace by real userId from DB
        String role = "RESIDENT";

        String token = jwtTokenProvider.generateToken(userId, email, role);
        return ResponseEntity.ok(token);
    }
}
