// package com.example.demo.controller;

// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/auth")
// public class AuthController {

//     private final UserRepository userRepository;
//     private final PasswordEncoder passwordEncoder;

//     public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//         this.userRepository = userRepository;
//         this.passwordEncoder = passwordEncoder;
//     }

//     @PostMapping("/register")
//     public User register(@RequestParam String username,
//                          @RequestParam String email,
//                          @RequestParam String password,
//                          @RequestParam(defaultValue = "USER") String role) {

//         // Encode the password
//         String encodedPassword = passwordEncoder.encode(password);

//         // Create new User
//         User user = new User(username, email, encodedPassword, role);

//         // Save to DB
//         return userRepository.save(user);
//     }
// }
