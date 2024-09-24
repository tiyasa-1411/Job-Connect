  package com.example.jobconnect.repository;

import com.example.jobconnect.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom query methods if needed
    User findByUsername(String username);
}