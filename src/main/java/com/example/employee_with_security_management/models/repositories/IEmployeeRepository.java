package com.example.employee_with_security_management.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee_with_security_management.models.entities.Employee;

public interface IEmployeeRepository
        extends JpaRepository<Employee, Long> {
}
