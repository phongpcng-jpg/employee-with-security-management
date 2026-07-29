package com.example.employee_with_security_management.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee_with_security_management.models.constants.RoleName;
import com.example.employee_with_security_management.models.entities.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(RoleName roleName);
}
