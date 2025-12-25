
// package com.example.demo.repository;

// import java.util.Optional;

// import org.springframework.data.jpa.repository.JpaRepository;

// import com.example.demo.model.User;

// public interface UserRepository extends JpaRepository<User, Long> {

//     boolean existsByEmail(String email);

//     Optional<User> findByEmail(String email);
// }







package com.example.demo.repository;

import com.example.demo.model.User;
import java.util.Optional;

public interface UserRepository {
    boolean existsByEmail(String email);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    User save(User user);
}
