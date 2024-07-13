package org.example.colorado.service.adminService;

import lombok.RequiredArgsConstructor;
import org.example.colorado.dto.UsersDto;
import org.example.colorado.entity.Users;
import org.example.colorado.repository.UsersRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;

    public String signUp(UsersDto registrationRequest) {
        try {
            Users user = new Users();
            user.setName(registrationRequest.getName());
            user.setTelephoneNumber(registrationRequest.getTelephonnumber());
            user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            user.setRoles(registrationRequest.getRole());
            usersRepository.save(user);

            return "Success: User registered successfully!";
        } catch (Exception e) {
            // Log the exception or handle it in a way suitable for your application
            return "Error: Failed to sign up user - " + e.getMessage();
        }
    }


    }

