package com.example.employee_with_security_management.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.employee_with_security_management.models.entities.User;

public interface IUserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
