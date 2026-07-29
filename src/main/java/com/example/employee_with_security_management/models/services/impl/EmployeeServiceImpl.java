package com.example.employee_with_security_management.models.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employee_with_security_management.models.dtos.res.EmployeeResponse;
import com.example.employee_with_security_management.models.services.IEmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl
        implements IEmployeeService {

    @Override
    public List<EmployeeResponse> getAll() {

        return List.of(
                EmployeeResponse.builder()
                        .id(1L)
                        .fullName("John Smith")
                        .salary(1500D)
                        .build(),

                EmployeeResponse.builder()
                        .id(2L)
                        .fullName("Emma Watson")
                        .salary(1800D)
                        .build(),

                EmployeeResponse.builder()
                        .id(3L)
                        .fullName("Michael Brown")
                        .salary(2100D)
                        .build()
        );
    }

}
