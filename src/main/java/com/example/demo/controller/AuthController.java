// package com.example.demo.controller;

// import com.example.demo.dto.*;
// import com.example.demo.model.User;
// import com.example.demo.security.JwtTokenProvider;
// import com.example.demo.service.UserService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserService userService;
//     private final JwtTokenProvider jwtTokenProvider;

//     public AuthController(UserService userService,
//                           JwtTokenProvider jwtTokenProvider) {
//         this.userService = userService;
//         this.jwtTokenProvider = jwtTokenProvider;
//     }

//     @PostMapping("/register")
//     public User register(@RequestBody RegisterRequest req) {
//         User u = new User(null, req.getName(),
//                 req.getEmail(), req.getPassword(), "RESIDENT", null);
//         return userService.register(u);
//     }

//     @PostMapping("/login")
//     public LoginResponse login() {
//         return null;
//     }
// }
// package com.example.demo.controller;

// import com.example.demo.dto.LoginRequest;
// import com.example.demo.dto.LoginResponse;
// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.model.User;
// import com.example.demo.security.JwtTokenProvider;
// import com.example.demo.service.UserService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserService userService;
//     private final JwtTokenProvider jwtTokenProvider;

//     public AuthController(UserService userService,
//                           JwtTokenProvider jwtTokenProvider) {
//         this.userService = userService;
//         this.jwtTokenProvider = jwtTokenProvider;
//     }

//     // ================= REGISTER =================
//     @PostMapping(
//             value = "/register",
//             consumes = "application/json",
//             produces = "application/json"
//     )
//     public User register(@RequestBody RegisterRequest request) {

//         User user = new User(
//                 null,
//                 request.getName(),
//                 request.getEmail(),
//                 request.getPassword(), // plain password (BCrypt optional later)
//                 "RESIDENT",
//                 null
//         );

//         return userService.register(user);
//     }

//     // ================= LOGIN =================
//     @PostMapping(
//             value = "/login",
//             consumes = "application/json",
//             produces = "application/json"
//     )
//     public LoginResponse login(@RequestBody LoginRequest request) {

//         // 1️⃣ Find user
//         User user = userService.findByEmail(request.getEmail());

//         // 2️⃣ Validate credentials
//         if (user == null || !user.getPassword().equals(request.getPassword())) {
//             throw new RuntimeException("Invalid email or password");
//         }

//         // 3️⃣ Generate JWT
//         String token = jwtTokenProvider.createToken(
//                 user.getEmail(),
//                 user.getRole()
//         );

//         // 4️⃣ Return response
//         return new LoginResponse(
//                 token,
//                 user.getId(),
//                 user.getEmail(),
//                 user.getRole()
//         );
//     }
// }
// package com.example.demo.controller;

// import com.example.demo.dto.LoginRequest;
// import com.example.demo.dto.LoginResponse;
// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.model.User;
// import com.example.demo.security.JwtTokenProvider;
// import com.example.demo.service.UserService;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserService userService;
//     private final JwtTokenProvider jwtTokenProvider;
//     private final PasswordEncoder passwordEncoder;

//     public AuthController(UserService userService,
//                           JwtTokenProvider jwtTokenProvider,
//                           PasswordEncoder passwordEncoder) {
//         this.userService = userService;
//         this.jwtTokenProvider = jwtTokenProvider;
//         this.passwordEncoder = passwordEncoder;
//     }

//     // ================= REGISTER =================
//     @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
//     public User register(@RequestBody RegisterRequest request) {

//         User user = new User(
//                 null,
//                 request.getName(),
//                 request.getEmail(),
//                 passwordEncoder.encode(request.getPassword()), // ✅ HASHED
//                 "RESIDENT",
//                 null
//         );

//         return userService.register(user);
//     }

//     // ================= LOGIN =================
//     @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
//     public LoginResponse login(@RequestBody LoginRequest request) {

//         User user = userService.findByEmail(request.getEmail());

//         // ✅ CORRECT password validation
//         if (user == null || !passwordEncoder.matches(
//                 request.getPassword(),
//                 user.getPassword()
//         )) {
//             throw new RuntimeException("Invalid email or password");
//         }

//         // ✅ CORRECT token generation
//         String token = jwtTokenProvider.generateToken(
//                 user.getId(),
//                 user.getEmail(),
//                 user.getRole()
//         );

//         return new LoginResponse(
//                 token,
//                 user.getId(),
//                 user.getEmail(),
//                 user.getRole()
//         );
//     }
// }
package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService,
                          JwtTokenProvider jwtTokenProvider,
                          PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    // ================= REGISTER =================
    @PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
    public User register(@RequestBody RegisterRequest request) {

        // ❌ DO NOT encode password here
        User user = new User(
                null,
                request.getName(),
                request.getEmail(),
                request.getPassword(), // plain password
                "RESIDENT",
                null
        );

        return userService.register(user); // encoded in service
    }

    // ================= LOGIN =================
    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public LoginResponse login(@RequestBody LoginRequest request) {

        User user = userService.findByEmail(request.getEmail());

        if (user == null || !passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        )) {
            throw new RuntimeException("Invalid email or password");
        }

        // ✅ Correct JWT method
        String token = jwtTokenProvider.createToken(
                user.getEmail(),
                user.getRole()
        );

        return new LoginResponse(
                token,
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
    }
}
