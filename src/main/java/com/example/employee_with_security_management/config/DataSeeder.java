package com.example.employee_with_security_management.config;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.employee_with_security_management.exceptions.NotFoundException;
import com.example.employee_with_security_management.models.constants.RoleName;
import com.example.employee_with_security_management.models.entities.Employee;
import com.example.employee_with_security_management.models.entities.Role;
import com.example.employee_with_security_management.models.entities.User;
import com.example.employee_with_security_management.models.repositories.IEmployeeRepository;
import com.example.employee_with_security_management.models.repositories.IRoleRepository;
import com.example.employee_with_security_management.models.repositories.IUserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class DataSeeder {

    private final IEmployeeRepository employeeRepository;

    private final IRoleRepository roleRepository;

    private final IUserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initDatabase() {

        return args -> {

            if (employeeRepository.count() == 0) {

                employeeRepository.saveAll(List.of(

                        Employee.builder()
                                .fullName("John Smith")
                                .salary(1500D)
                                .build(),

                        Employee.builder()
                                .fullName("Emma Watson")
                                .salary(1800D)
                                .build(),

                        Employee.builder()
                                .fullName("Michael Brown")
                                .salary(2200D)
                                .build()

                ));

            }

            if(roleRepository.count() == 0) {
                roleRepository.saveAll(
                        List.of(
                                Role.builder().roleName(RoleName.ROLE_ADMIN).build(),
                                Role.builder().roleName(RoleName.ROLE_USER).build()
                        )
                );
            }

            if (userRepository.count() == 0) {

                Set<Role> rolesAdmin = new HashSet<>();
                rolesAdmin.add(
                        roleRepository.findByRoleName(RoleName.ROLE_ADMIN)
                                .orElseThrow(() -> new NotFoundException("Role not found"))
                );

                Set<Role> rolesUser = new HashSet<>();
                rolesAdmin.add(
                        roleRepository.findByRoleName(RoleName.ROLE_USER)
                                .orElseThrow(() -> new NotFoundException("Role not found"))
                );

                userRepository.saveAll(List.of(

                        User.builder()
                                .username("admin")
                                .password(passwordEncoder.encode("123456"))
                                .roles(rolesAdmin)
                                .enabled(true)
                                .build(),

                        User.builder()
                                .username("user")
                                .password(passwordEncoder.encode("123456"))
                                .roles(rolesUser)
                                .enabled(true)
                                .build()

                ));

            }

        };
    }

}