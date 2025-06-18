package com.docs.service;

import com.docs.dto.UserDTO;
import com.docs.entity.Users;
import com.docs.entity.Users.Role;
import com.docs.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public String registerUser(UserDTO dto) {

        Optional<Users> existingUser = repo.findByUsername(dto.getUsername());
        if (existingUser.isPresent()) {
            return "User already exists!";
        }

        Users user = new Users();
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(Role.VIEWER); // Or any default role

        repo.save(user);
        return "User registered successfully!";
    }
}
