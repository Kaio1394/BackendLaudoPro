package com.kaiosantiago.laudopro.controllers;

import com.kaiosantiago.laudopro.dtos.user.UserCreateDto;
import com.kaiosantiago.laudopro.dtos.user.UserDto;
import com.kaiosantiago.laudopro.schemas.ApiResponseList;
import com.kaiosantiago.laudopro.schemas.ApiResponseModel;
import com.kaiosantiago.laudopro.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<ApiResponseList<UserDto>>> getAll(){
        var future = service.getAll();
        return future.thenApply(list -> {
            var response = new ApiResponseList<UserDto>();
            response.setList(list);
            response.setMessage(null);
            return ResponseEntity.ok(response);
        }).exceptionally(ex -> {
            var response = new ApiResponseList<UserDto>();
            response.setMessage("Error: " + ex.getMessage());
            response.setList(List.of());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        });
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<ApiResponseModel<UserDto>>> addUser(@RequestBody @Valid UserCreateDto dtoCreate){
        var future = service.addUser(dtoCreate);
        return future.thenApply(user -> {
            var response = new ApiResponseModel<UserDto>();
            response.setModel(user);
            response.setMessage("User created with successfully.");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }).exceptionally(ex -> {
            var response = new ApiResponseModel<UserDto>();
            response.setModel(null);
            response.setMessage("Error: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        });
    }
}
