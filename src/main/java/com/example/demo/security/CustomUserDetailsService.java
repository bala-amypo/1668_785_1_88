// src/main/java/com/example/demo/security/CustomUserDetailsService.java
package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface CustomUserDetailsService extends UserDetailsService {
}
// // src/main/java/com/example/demo/security/CustomUserDetailsService.java
// package com.example.demo.security;

// import org.springframework.security.core.userdetails.UserDetailsService;

// public interface CustomUserDetailsService extends UserDetailsService {
//     // no extra methods needed for tests
// }
// package com.example.demo.security;

// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// @Service
// public class CustomUserDetailsService implements UserDetailsService {

//     private final UserRepository userRepository;

//     public CustomUserDetailsService(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     @Override
//     public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//         User user = userRepository.findByEmail(email)
//                 .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));

//         return org.springframework.security.core.userdetails.User
//                 .withUsername(user.getEmail())
//                 .password(user.getPassword())
//                 .roles(user.getRole()) // must be "USER" or "ADMIN"
//                 .build();
//     }
// }
