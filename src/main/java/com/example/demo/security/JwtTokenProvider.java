// package com.example.demo.security;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import org.springframework.stereotype.Component;

// import java.util.Date;

// @Component
// public class JwtTokenProvider {

//     private String jwtSecret = "defaultSecretKey"; 
//     private long jwtExpirationInMs = 3600000; // 1 hour

//     public JwtTokenProvider() {}

//     public JwtTokenProvider(String jwtSecret, long jwtExpirationInMs) {
//         this.jwtSecret = jwtSecret;
//         this.jwtExpirationInMs = jwtExpirationInMs;
//     }

//     public String generateToken(String username) {
//         Date now = new Date();
//         Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

//         return Jwts.builder()
//                 .setSubject(username)
//                 .setIssuedAt(now)
//                 .setExpiration(expiryDate)
//                 .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                 .compact();
//     }

//     private Claims getClaimsFromToken(String token) {
//         return Jwts.parser()
//                 .setSigningKey(jwtSecret)
//                 .parseClaimsJws(token)
//                 .getBody();
//     }

//     public String getEmailFromToken(String token) {
//         return getClaimsFromToken(token).getSubject();
//     }

//     public Long getUserIdFromToken(String token) {
//         Object userId = getClaimsFromToken(token).get("userId");
//         return userId != null ? Long.valueOf(userId.toString()) : null;
//     }

//     public String getRoleFromToken(String token) {
//         Object role = getClaimsFromToken(token).get("role");
//         return role != null ? role.toString() : null;
//     }
// }
