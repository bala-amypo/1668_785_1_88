// src/main/java/com/example/demo/security/JwtTokenProvider.java
package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;

public class JwtTokenProvider {

    private final String jwtSecret;
    private final long jwtExpirationInMs;
    private final Key key;

    public JwtTokenProvider(String jwtSecret, long jwtExpirationInMs) {
        this.jwtSecret = jwtSecret;
        this.jwtExpirationInMs = jwtExpirationInMs;
        this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public String generateToken(Authentication authentication,
                                Long userId,
                                String email,
                                String role) {
        Object principal = authentication.getPrincipal();
        String username;
        if (principal instanceof UserDetails ud) {
            username = ud.getUsername();
        } else {
            username = principal.toString();
        }

        Date now = new Date();
        Date expiry = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(String.valueOf(userId))
                .claim("email", email)
                .claim("role", role)
                .claim("username", username)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    private Claims parseClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (JwtException ex) {
            return null;
        }
    }

    public Long getUserIdFromToken(String token) {
        Claims claims = parseClaims(token);
        if (claims == null) return null;
        String sub = claims.getSubject();
        if (sub == null) return null;
        try {
            return Long.valueOf(sub);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public String getEmailFromToken(String token) {
        Claims claims = parseClaims(token);
        return claims != null ? claims.get("email", String.class) : null;
    }

    public String getRoleFromToken(String token) {
        Claims claims = parseClaims(token);
        return claims != null ? claims.get("role", String.class) : null;
    }

    public boolean validateToken(String token) {
        Claims claims = parseClaims(token);
        if (claims == null) return false;
        Date exp = claims.getExpiration();
        return exp == null || exp.after(new Date());
    }
}
// // src/main/java/com/example/demo/security/JwtTokenProvider.java
// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.userdetails.UserDetails;

// import java.security.Key;
// import java.util.Date;

// public class JwtTokenProvider {

//     private final String jwtSecret;
//     private final long jwtExpirationInMs;
//     private final Key key;

//     public JwtTokenProvider(String jwtSecret, long jwtExpirationInMs) {
//         this.jwtSecret = jwtSecret;
//         this.jwtExpirationInMs = jwtExpirationInMs;
//         this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
//     }

//     public String generateToken(Authentication authentication,
//                                 Long userId,
//                                 String email,
//                                 String role) {
//         Object principal = authentication.getPrincipal();
//         String username;
//         if (principal instanceof UserDetails ud) {
//             username = ud.getUsername();
//         } else {
//             username = principal.toString();
//         }

//         Date now = new Date();
//         Date expiry = new Date(now.getTime() + jwtExpirationInMs);

//         return Jwts.builder()
//                 .setSubject(String.valueOf(userId))
//                 .claim("email", email)
//                 .claim("role", role)
//                 .claim("username", username)
//                 .setIssuedAt(now)
//                 .setExpiration(expiry)
//                 .signWith(key, SignatureAlgorithm.HS256)
//                 .compact();
//     }

//     private Claims parseClaims(String token) {
//         try {
//             return Jwts.parserBuilder()
//                     .setSigningKey(key)
//                     .build()
//                     .parseClaimsJws(token)
//                     .getBody();
//         } catch (JwtException ex) {
//             return null;
//         }
//     }

//     public Long getUserIdFromToken(String token) {
//         Claims claims = parseClaims(token);
//         if (claims == null) {
//             return null;
//         }
//         String sub = claims.getSubject();
//         if (sub == null) return null;
//         try {
//             return Long.valueOf(sub);
//         } catch (NumberFormatException e) {
//             return null;
//         }
//     }

//     public String getEmailFromToken(String token) {
//         Claims claims = parseClaims(token);
//         return claims != null ? claims.get("email", String.class) : null;
//     }

//     public String getRoleFromToken(String token) {
//         Claims claims = parseClaims(token);
//         return claims != null ? claims.get("role", String.class) : null;
//     }

//     public boolean validateToken(String token) {
//         Claims claims = parseClaims(token);
//         if (claims == null) return false;
//         Date exp = claims.getExpiration();
//         return exp == null || exp.after(new Date());
//     }
// }
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
