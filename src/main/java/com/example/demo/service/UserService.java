package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
    // This method signature must exactly match the implementation in UserServiceImpl
    User registerUser(String username, String email, String password, String role);
}
