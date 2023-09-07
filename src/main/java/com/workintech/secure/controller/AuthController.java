package com.workintech.secure.controller;

import com.workintech.secure.dto.RegistrationMember;
import com.workintech.secure.entity.Member;
import com.workintech.secure.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public Member register(@RequestBody RegistrationMember registrationMember){
        return authenticationService.register(registrationMember.getEmail(), registrationMember.getPassword());
    }
}
