package com.kaiosantiago.laudopro.controllers;

import com.kaiosantiago.laudopro.dtos.customer.CustomerCreateDto;
import com.kaiosantiago.laudopro.dtos.customer.CustomerDto;
import com.kaiosantiago.laudopro.schemas.ApiResponseCreateCustomer;
import com.kaiosantiago.laudopro.schemas.ApiResponseGetAllCustomers;
import com.kaiosantiago.laudopro.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<ApiResponseCreateCustomer>> addCustomer(@RequestBody @Valid CustomerCreateDto dto) {
        return this.service.createAsync(dto).thenApply(customerDto -> {
            ApiResponseCreateCustomer response = new ApiResponseCreateCustomer();
            response.setCustomer(customerDto);
            response.setMessage("Created successfully.");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }).exceptionally(ex -> {
            ApiResponseCreateCustomer response = new ApiResponseCreateCustomer();
            response.setCustomer(null);
            response.setMessage("Error: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        });
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<ApiResponseGetAllCustomers>> getAllCustomers() {
        return service.getAllCustomersAsync().thenApply(list -> {
            ApiResponseGetAllCustomers response = new ApiResponseGetAllCustomers();
            response.setListCustomers(list);
            response.setMessage(null);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }).exceptionally(ex -> {
            ApiResponseGetAllCustomers response = new ApiResponseGetAllCustomers();
            response.setListCustomers(List.of());
            response.setMessage("Error: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        });
    }

    @GetMapping("/uuid/{uuid}")
    public String getCustomerByUuid(@PathVariable String uuid) {
        return "sfsf";
    }
}
