package com.kaiosantiago.laudopro.controllers;

import com.kaiosantiago.laudopro.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private final JwtService service;

    public AuthController(JwtService service) {
        this.service = service;
    }
}
