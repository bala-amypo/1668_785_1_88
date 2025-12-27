package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component   // ⭐ THIS IS REQUIRED
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        // JWT validation logic here

        filterChain.doFilter(request, response);
    }
}
// package com.example.demo.security;

// import jakarta.servlet.*;
// import jakarta.servlet.http.HttpServletRequest;
// import java.io.IOException;

// public class JwtAuthenticationFilter implements Filter {

//     @Override
//     public void doFilter(ServletRequest request,
//                          ServletResponse response,
//                          FilterChain chain)
//             throws IOException, ServletException {
//         chain.doFilter(request, response);
//     }
// }