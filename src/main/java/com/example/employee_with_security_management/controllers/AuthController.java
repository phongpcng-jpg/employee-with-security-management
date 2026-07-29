package com.example.employee_with_security_management.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_with_security_management.models.dtos.res.ApiResponse;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @GetMapping("/test")
    public ResponseEntity<ApiResponse<String>> test() {

        return ResponseEntity.ok(

                ApiResponse.<String>builder()
                        .success(true)
                        .message("Public API")
                        .data("Security Config Success")
                        .build()

        );
    }

}