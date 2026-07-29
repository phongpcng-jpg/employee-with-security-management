package com.example.employee_with_security_management.models.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employee_with_security_management.models.dtos.res.EmployeeResponse;
import com.example.employee_with_security_management.models.repositories.IEmployeeRepository;
import com.example.employee_with_security_management.models.services.IEmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl
        implements IEmployeeService {

    private final IEmployeeRepository employeeRepository;

    @Override
    public List<EmployeeResponse> getAll() {

        return employeeRepository.findAll().stream()
                .map(
                        employee -> EmployeeResponse.builder()
                                .id(employee.getId())
                                .fullName(employee.getFullName())
                                .salary(employee.getSalary()).build()
                )
                .toList();
    }

}
