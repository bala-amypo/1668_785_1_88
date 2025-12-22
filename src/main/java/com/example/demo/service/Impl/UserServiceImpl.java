
package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired 
    UserRepository used;

    @Override
    public User postData1(User use) {
        if (used.existsByEmail(use.getEmail())) {
            throw new RuntimeException("User already exists with this email");
        }
        return used.save(use);
    }

    @Override
    public User postdata(User log) {
        User user = used.findByEmail(log.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!user.getPassword().equals(log.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        return user;
    }

    @Override
    public List<User> getAllData1() {
        List<User> list = used.findAll();
        if (list.isEmpty()) {
            throw new RuntimeException("No users found");
        }
        return list;
    }

    @Override
    public String DeleteData1(Long id) {
        if (!used.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        used.deleteById(id);
        return "Deleted successfully";
    }

    @Override
    public User getData1(Long id) {
        return used.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public User updateData1(Long id, User entity) {
        if (!used.existsById(id)) {
            throw new RuntimeException("Cannot update. User not found with id: " + id);
        }
        entity.setId(id);
        return used.save(entity);
    }
}