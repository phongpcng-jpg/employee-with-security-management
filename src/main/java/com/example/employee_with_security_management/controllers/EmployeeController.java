package com.example.employee_with_security_management.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_with_security_management.models.dtos.res.ApiResponse;
import com.example.employee_with_security_management.models.dtos.res.EmployeeResponse;
import com.example.employee_with_security_management.models.services.IEmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeService employeeService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<EmployeeResponse>>> getAll() {

        return ResponseEntity.ok(
                ApiResponse.<List<EmployeeResponse>>builder()
                        .success(true)
                        .message("Employee list")
                        .data(employeeService.getAll())
                        .build()
        );
    }

}
