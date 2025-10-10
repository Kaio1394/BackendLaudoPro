package com.kaiosantiago.laudopro.controllers;

import com.kaiosantiago.laudopro.dtos.user.UserCreateDto;
import com.kaiosantiago.laudopro.dtos.user.UserDto;
import com.kaiosantiago.laudopro.schemas.ApiResponseCreateUser;
import com.kaiosantiago.laudopro.schemas.ApiResponseGetAllUsers;
import com.kaiosantiago.laudopro.services.PlanService;
import com.kaiosantiago.laudopro.services.UserService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<ApiResponseGetAllUsers>> getAll(){
        var future = service.getAll();
        return future.thenApply(list -> {
            var response = new ApiResponseGetAllUsers();
            response.setUsers(list);
            response.setMessage(null);
            return ResponseEntity.ok(response);
        }).exceptionally(ex -> {
            var response = new ApiResponseGetAllUsers();
            response.setMessage("Error: " + ex.getMessage());
            response.setUsers(null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        });
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<ApiResponseCreateUser>> addUser(@RequestBody @Valid UserCreateDto dtoCreate){
        var future = service.addUser(dtoCreate);
        return future.thenApply(user -> {
            var response = new ApiResponseCreateUser();
            response.setUser(user);
            response.setMessage("User created with successfully.");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }).exceptionally(ex -> {
            var response = new ApiResponseCreateUser();
            response.setUser(null);
            response.setMessage("Error: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        });
    }
}
