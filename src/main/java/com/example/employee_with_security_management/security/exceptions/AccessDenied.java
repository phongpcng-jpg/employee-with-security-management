package com.example.employee_with_security_management.security.exceptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@Component
public class AccessDenied implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.error("Un Authentication {}", accessDeniedException.getMessage());
        response.setHeader("error","FORBIDDEN");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(403);
        Map<String, Object> errors = new HashMap<>();
        errors.put("code",403);
        errors.put("error",accessDeniedException.getMessage());
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(),errors);
    }
    
}