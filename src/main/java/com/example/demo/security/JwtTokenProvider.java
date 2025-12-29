// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.security.core.Authentication;
// import org.springframework.stereotype.Component;

// import java.security.Key;
// import java.util.Date;

// @Component
// public class JwtTokenProvider {

//     private final Key key;
//     private final long expirationMs;

//     public JwtTokenProvider(String secret, long expirationMs) {
//         this.key = Keys.hmacShaKeyFor(secret.getBytes());
//         this.expirationMs = expirationMs;
//     }

//     public String generateToken(Authentication authentication,
//                                 Long userId,
//                                 String email,
//                                 String role) {

//         return Jwts.builder()
//                 .setSubject(String.valueOf(userId))
//                 .claim("email", email)
//                 .claim("role", role)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
//                 .signWith(key, SignatureAlgorithm.HS256)
//                 .compact();
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parserBuilder()
//                     .setSigningKey(key)
//                     .build()
//                     .parseClaimsJws(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     public Long getUserIdFromToken(String token) {
//         return Long.parseLong(getClaims(token).getSubject());
//     }

//     public String getEmailFromToken(String token) {
//         return getClaims(token).get("email", String.class);
//     }

//     public String getRoleFromToken(String token) {
//         return getClaims(token).get("role", String.class);
//     }

//     private Claims getClaims(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(key)
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }


// // package com.example.demo.security;

// // import io.jsonwebtoken.*;
// // import io.jsonwebtoken.security.Keys;
// // import org.springframework.beans.factory.annotation.Value;
// // import org.springframework.stereotype.Component;

// // import java.security.Key;
// // import java.util.Date;

// // @Component
// // public class JwtTokenProvider {

// //     private final Key key;
// //     private final long expirationMs;

// //     public JwtTokenProvider(
// //             @Value("${jwt.secret}") String secret,
// //             @Value("${jwt.expiration}") long expirationMs) {

// //         this.key = Keys.hmacShaKeyFor(secret.getBytes());
// //         this.expirationMs = expirationMs;
// //     }

// //     // ================= TOKEN GENERATION =================
// //     public String createToken(String email, String role) {

// //         return Jwts.builder()
// //                 .setSubject(email)
// //                 .claim("role", role)
// //                 .setIssuedAt(new Date())
// //                 .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
// //                 .signWith(key, SignatureAlgorithm.HS256)
// //                 .compact();
// //     }

// //     // ================= TOKEN VALIDATION =================
// //     public boolean validateToken(String token) {
// //         try {
// //             Jwts.parserBuilder()
// //                     .setSigningKey(key)
// //                     .build()
// //                     .parseClaimsJws(token);
// //             return true;
// //         } catch (JwtException | IllegalArgumentException e) {
// //             return false;
// //         }
// //     }

// //     // ================= TOKEN DATA EXTRACTION =================
// //     public String getEmailFromToken(String token) {
// //         return getClaims(token).getSubject();
// //     }

// //     public String getRoleFromToken(String token) {
// //         return getClaims(token).get("role", String.class);
// //     }

// //     private Claims getClaims(String token) {
// //         return Jwts.parserBuilder()
// //                 .setSigningKey(key)
// //                 .build()
// //                 .parseClaimsJws(token)
// //                 .getBody();
// //     }
// // }
// // package com.example.demo.security;

// // import io.jsonwebtoken.*;
// // import io.jsonwebtoken.security.Keys;
// // import org.springframework.beans.factory.annotation.Value;
// // import org.springframework.stereotype.Component;

// // import java.security.Key;
// // import java.util.Date;

// // @Component
// // public class JwtTokenProvider {

// //     private final Key key;
// //     private final long expirationMs;
// //     public JwtTokenProvider(
// //             @Value("${jwt.secret}") String secret,
// //             @Value("${jwt.expiration}") long expirationMs) {

// //         this.key = Keys.hmacShaKeyFor(secret.getBytes());
// //         this.expirationMs = expirationMs;
// //     }

// //     public String generateToken(org.springframework.security.core.Authentication auth,
// //                                 Long userId,
// //                                 String email,
// //                                 String role) {

// //         return Jwts.builder()
// //                 .setSubject(userId.toString())
// //                 .claim("email", email)
// //                 .claim("role", role)
// //                 .setIssuedAt(new Date())
// //                 .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
// //                 .signWith(key, SignatureAlgorithm.HS256)
// //                 .compact();
// //     }

// //     public boolean validateToken(String token) {
// //         try {
// //             Jwts.parserBuilder()
// //                     .setSigningKey(key)
// //                     .build()
// //                     .parseClaimsJws(token);
// //             return true;
// //         } catch (JwtException | IllegalArgumentException e) {
// //             return false;
// //         }
// //     }

// //     public Long getUserIdFromToken(String token) {
// //         Claims claims = parse(token);
// //         return claims.get("userId", Long.class) != null
// //                 ? claims.get("userId", Long.class)
// //                 : Long.valueOf(claims.getSubject());
// //     }

// //     public String getEmailFromToken(String token) {
// //         return parse(token).get("email", String.class);
// //     }

// //     public String getRoleFromToken(String token) {
// //         return parse(token).get("role", String.class);
// //     }

// //     private Claims parse(String token) {
// //         return Jwts.parserBuilder()
// //                 .setSigningKey(key)
// //                 .build()
// //                 .parseClaimsJws(token)
// //                 .getBody();
// //     }
// // }

// // // package com.example.demo.security;

// // // import io.jsonwebtoken.*;
// // // import io.jsonwebtoken.security.Keys;
// // // import org.springframework.security.core.Authentication;

// // // import java.security.Key;
// // // import java.util.Date;

// // // public class JwtTokenProvider {

// // //     private final Key key;
// // //     private final long validityInMs;

// // //     // STRICT constructor
// // //     public JwtTokenProvider(String secret, long validityInMs) {
// // //         this.key = Keys.hmacShaKeyFor(secret.getBytes());
// // //         this.validityInMs = validityInMs;
// // //     }

// // //     public String generateToken(Authentication authentication,
// // //                                 Long userId,
// // //                                 String email,
// // //                                 String role) {

// // //         Date now = new Date();
// // //         Date expiry = new Date(now.getTime() + validityInMs);

// // //         return Jwts.builder()
// // //                 .setSubject(String.valueOf(userId))
// // //                 .claim("userId", userId)
// // //                 .claim("email", email)
// // //                 .claim("role", role)
// // //                 .setIssuedAt(now)
// // //                 .setExpiration(expiry)
// // //                 .signWith(key, SignatureAlgorithm.HS256)
// // //                 .compact();
// // //     }

// // //     public boolean validateToken(String token) {
// // //         try {
// // //             Jwts.parserBuilder()
// // //                 .setSigningKey(key)
// // //                 .build()
// // //                 .parseClaimsJws(token);
// // //             return true;
// // //         } catch (Exception ex) {
// // //             return false;
// // //         }
// // //     }

// // //     public Long getUserIdFromToken(String token) {
// // //         Claims claims = getClaims(token);
// // //         if (claims.get("userId") != null) {
// // //             return claims.get("userId", Long.class);
// // //         }
// // //         return Long.valueOf(claims.getSubject());
// // //     }

// // //     public String getEmailFromToken(String token) {
// // //         return getClaims(token).get("email", String.class);
// // //     }

// // //     public String getRoleFromToken(String token) {
// // //         return getClaims(token).get("role", String.class);
// // //     }

// // //     private Claims getClaims(String token) {
// // //         return Jwts.parserBuilder()
// // //                 .setSigningKey(key)
// // //                 .build()
// // //                 .parseClaimsJws(token)
// // //                 .getBody();
// // //     }
// // // }
// // package com.example.demo.security;

// // import io.jsonwebtoken.*;
// // import io.jsonwebtoken.security.Keys;
// // import org.springframework.beans.factory.annotation.Value;
// // import org.springframework.stereotype.Component;

// // import java.security.Key;
// // import java.util.Date;

// // @Component
// // public class JwtTokenProvider {

// //     private final Key key;
// //     private final long expirationMs;

// //     public JwtTokenProvider(
// //             @Value("${jwt.secret}") String secret,
// //             @Value("${jwt.expiration}") long expirationMs) {

// //         this.key = Keys.hmacShaKeyFor(secret.getBytes());
// //         this.expirationMs = expirationMs;
// //     }

// //     // =================== NEW SIMPLE TOKEN METHOD ===================
// //     public String createToken(String email, String role) {
// //         return Jwts.builder()
// //                 .setSubject(email)
// //                 .claim("email", email)
// //                 .claim("role", role)
// //                 .setIssuedAt(new Date())
// //                 .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
// //                 .signWith(key, SignatureAlgorithm.HS256)
// //                 .compact();
// //     }

// //     // =================== EXISTING ADVANCED TOKEN METHOD ===================
// //     public String generateToken(org.springframework.security.core.Authentication auth,
// //                                 Long userId,
// //                                 String email,
// //                                 String role) {

// //         return Jwts.builder()
// //                 .setSubject(userId.toString())
// //                 .claim("email", email)
// //                 .claim("role", role)
// //                 .setIssuedAt(new Date())
// //                 .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
// //                 .signWith(key, SignatureAlgorithm.HS256)
// //                 .compact();
// //     }

// //     // =================== TOKEN VALIDATION ===================
// //     public boolean validateToken(String token) {
// //         try {
// //             Jwts.parserBuilder()
// //                     .setSigningKey(key)
// //                     .build()
// //                     .parseClaimsJws(token);
// //             return true;
// //         } catch (JwtException | IllegalArgumentException e) {
// //             return false;
// //         }
// //     }

// //     // =================== GET DATA FROM TOKEN ===================
// //     public Long getUserIdFromToken(String token) {
// //         Claims claims = parse(token);
// //         return claims.get("userId", Long.class) != null
// //                 ? claims.get("userId", Long.class)
// //                 : Long.valueOf(claims.getSubject());
// //     }

// //     public String getEmailFromToken(String token) {
// //         return parse(token).get("email", String.class);
// //     }

// //     public String getRoleFromToken(String token) {
// //         return parse(token).get("role", String.class);
// //     }

// //     // =================== HELPER METHOD ===================
// //     private Claims parse(String token) {
// //         return Jwts.parserBuilder()
// //                 .setSigningKey(key)
// //                 .build()
// //                 .parseClaimsJws(token)
// //                 .getBody();
// //     }
// // //}
// // package com.example.demo.security;

// // import io.jsonwebtoken.*;
// // import io.jsonwebtoken.security.Keys;
// // import org.springframework.beans.factory.annotation.Value;
// // import org.springframework.stereotype.Component;

// // import java.security.Key;
// // import java.util.Date;

// // @Component
// // public class JwtTokenProvider {

// //     private final Key key;
// //     private final long expirationMs;

// //     public JwtTokenProvider(
// //             @Value("${jwt.secret}") String secret,
// //             @Value("${jwt.expiration}") long expirationMs) {

// //         // HS256 requires at least 32 bytes secret
// //         this.key = Keys.hmacShaKeyFor(secret.getBytes());
// //         this.expirationMs = expirationMs;
// //     }

// //     // =================== TOKEN GENERATION ===================
// //     public String generateToken(Long userId, String email, String role) {

// //         return Jwts.builder()
// //                 .setSubject(userId.toString())       // subject = userId
// //                 .claim("userId", userId)
// //                 .claim("email", email)
// //                 .claim("role", role)
// //                 .setIssuedAt(new Date())
// //                 .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
// //                 .signWith(key, SignatureAlgorithm.HS256)
// //                 .compact();
// //     }

// //     // =================== TOKEN VALIDATION ===================
// //     public boolean validateToken(String token) {
// //         try {
// //             Jwts.parserBuilder()
// //                     .setSigningKey(key)
// //                     .build()
// //                     .parseClaimsJws(token);
// //             return true;
// //         } catch (JwtException | IllegalArgumentException ex) {
// //             return false;
// //         }
// //     }

// //     // =================== READ DATA FROM TOKEN ===================
// //     public Long getUserIdFromToken(String token) {
// //         return parseClaims(token).get("userId", Long.class);
// //     }

// //     public String getEmailFromToken(String token) {
// //         return parseClaims(token).get("email", String.class);
// //     }

// //     public String getRoleFromToken(String token) {
// //         return parseClaims(token).get("role", String.class);
// //     }

// //     // =================== INTERNAL PARSER ===================
// //     private Claims parseClaims(String token) {
// //         return Jwts.parserBuilder()
// //                 .setSigningKey(key)
// //                 .build()
// //                 .parseClaimsJws(token)
// //                 .getBody();
// //     }
// // }
package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;


@Component
public class JwtTokenProvider {

    private final Key key;
    private final long expirationMs;

    public JwtTokenProvider(
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.expiration}") long expirationMs) {

        // HS256 requires at least 32 bytes secret
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
        this.expirationMs = expirationMs;
    }

    // ===== TOKEN GENERATION =====
    public String generateToken(Long userId, String email, String role) {

        return Jwts.builder()
                .setSubject(userId.toString())
                .claim("userId", userId)
                .claim("email", email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // ===== TOKEN VALIDATION =====
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException ex) {
            return false;
        }
    }

    // ===== READ DATA =====
    public Long getUserIdFromToken(String token) {
        return parseClaims(token).get("userId", Long.class);
    }

    public String getEmailFromToken(String token) {
        return parseClaims(token).get("email", String.class);
    }

    public String getRoleFromToken(String token) {
        return parseClaims(token).get("role", String.class);
    }

    private Claims parseClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
