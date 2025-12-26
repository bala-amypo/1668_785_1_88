// src/main/java/com/example/demo/servlet/SimpleHelloServlet.java
package com.example.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleHelloServlet extends HttpServlet {

    // Must be public because the test calls it directly
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setStatus(HttpServletResponse.SC_OK);
        try (PrintWriter out = resp.getWriter()) {
            out.write("Hello from Simple Servlet");
            out.flush();
        }
    }

    @Override
    public String getServletInfo() {
        return "SimpleHelloServlet";
    }
}
// // src/main/java/com/example/demo/servlet/SimpleHelloServlet.java
// package com.example.demo.servlet;

// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import java.io.IOException;
// import java.io.PrintWriter;

// public class SimpleHelloServlet extends HttpServlet {

//     // Make this public so ApartmentFacilityBookingSystemTest can call it.
//     @Override
//     public void doGet(HttpServletRequest req, HttpServletResponse resp)
//             throws ServletException, IOException {
//         resp.setContentType("text/plain");
//         resp.setStatus(HttpServletResponse.SC_OK);
//         try (PrintWriter out = resp.getWriter()) {
//             out.write("Hello from Simple Servlet");
//             out.flush();
//         }
//     }

//     @Override
//     public String getServletInfo() {
//         return "SimpleHelloServlet - basic servlet used in tests";
//     }
// }

// package com.example.demo.servlet;

// import jakarta.servlet.http.HttpServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import jakarta.servlet.ServletException;

// import java.io.IOException;

// public class SimpleHelloServlet extends HttpServlet {

//     @Override
//     protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//             throws ServletException, IOException {

//         resp.setContentType("text/plain");
//         resp.setStatus(HttpServletResponse.SC_OK);
//         resp.getWriter().write("Hello from Simple Servlet");
//     }

//     @Override
//     public String getServletInfo() {
//         return "SimpleHelloServlet";
//     }
// }
