package com.kaiosantiago.laudopro.controllers;

import com.kaiosantiago.laudopro.dtos.request.AuthenticateRequest;
import com.kaiosantiago.laudopro.mapper.UserMapper;
import com.kaiosantiago.laudopro.response.ApiResponseJwt;
import com.kaiosantiago.laudopro.services.JwtService;
import com.kaiosantiago.laudopro.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private final JwtService service;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(JwtService service, UserService userService, PasswordEncoder passwordEncoder) {
        this.service = service;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/auth")
    public CompletableFuture<ResponseEntity<ApiResponseJwt>> authenticate(@RequestBody @Valid AuthenticateRequest auth){
        var username = auth.getUsername();
        var password = auth.getPassword();
        var future = userService.getUserByUsername(username);
        return future.thenApply(userResponse -> {
            if(userResponse == null){
                throw new RuntimeException("User not found.");
            }
            if(!passwordEncoder.matches(password, userResponse.getPassword())){
                throw new RuntimeException("Password invalid.");
            }
            var user = UserMapper.userResponseToUserCreateResponse(userResponse);
            var response = new ApiResponseJwt();
            response.setMessage(null);
            response.setType("Bearer");
            response.setUser(user);
            response.setExpiresIn(3600);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        });
    }
}
