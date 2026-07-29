package com.example.employee_with_security_management.security.principal;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.employee_with_security_management.models.entities.User;
import com.example.employee_with_security_management.models.repositories.IUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        CustomUserDetails customUserDetails = CustomUserDetails.builder()
                .user(user)
                .authorities(
                        user.getRoles().stream()
                                .map(role ->
                                        new SimpleGrantedAuthority(role.getRoleName().name()))
                                .toList()
                )
                .build();
        return customUserDetails;
    }
}
