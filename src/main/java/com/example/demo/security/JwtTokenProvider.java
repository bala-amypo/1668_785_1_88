// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.userdetails.UserDetails;

// import javax.crypto.SecretKey;
// import java.util.Date;

// public class JwtTokenProvider {

//     private final SecretKey key;
//     private final long expiration;

//     public JwtTokenProvider(String secret, long expiration) {
//         this.key = Keys.hmacShaKeyFor(secret.getBytes());
//         this.expiration = expiration;
//     }

//     public String generateToken(Authentication authentication,
//                                 Long userId,
//                                 String email,
//                                 String role) {

//         UserDetails ud = (UserDetails) authentication.getPrincipal();

//         return Jwts.builder()
//                 .setSubject(String.valueOf(userId))
//                 .claim("email", email)
//                 .claim("role", role)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + expiration))
//                 .signWith(key, SignatureAlgorithm.HS256)
//                 .compact();
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     private Claims claims(String token) {
//         return Jwts.parserBuilder().setSigningKey(key).build()
//                 .parseClaimsJws(token).getBody();
//     }

//     public Long getUserIdFromToken(String token) {
//         try {
//             return Long.valueOf(claims(token).getSubject());
//         } catch (Exception e) {
//             return null;
//         }
//     }

//     public String getEmailFromToken(String token) {
//         return claims(token).get("email", String.class);
//     }

//     public String getRoleFromToken(String token) {
//         return claims(token).get("role", String.class);
//     }
// }






package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    private final String secretKey = "yourSecretKey"; // Replace with secure key

    // Example method to generate a token
    public String generateToken(String username) {
        // Implementation for creating JWT token
        return "dummy-jwt-token-for-" + username;
    }

    // Example method to validate a token
    public boolean validateToken(String token) {
        // Implementation for validating JWT token
        return token.startsWith("dummy-jwt-token-for-");
    }

    // Example method to extract username
    public String getUsernameFromToken(String token) {
        // Implementation for extracting username from token
        return token.replace("dummy-jwt-token-for-", "");
    }
}
