package com.example.employee_with_security_management.models.services;

import java.util.List;

import com.example.employee_with_security_management.models.dtos.res.EmployeeResponse;

public interface IEmployeeService {

    List<EmployeeResponse> getAll();

}
