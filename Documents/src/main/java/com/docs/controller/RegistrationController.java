package com.docs.controller;

import com.docs.dto.UserDTO;
import com.docs.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<String> responseEntity(@RequestBody UserDTO dto){

        String s = registrationService.registerUser(dto);
        if(s.equals("User already exist!")){
            return ResponseEntity.badRequest().body(s);
        }

        return ResponseEntity.ok("User registered successfully...");
    }
}
