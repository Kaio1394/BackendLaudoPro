package com.kaiosantiago.laudopro.controllers;

import com.kaiosantiago.laudopro.dtos.customer.CustomerCreateDto;
import com.kaiosantiago.laudopro.dtos.customer.CustomerDto;
import com.kaiosantiago.laudopro.schemas.ApiResponseList;
import com.kaiosantiago.laudopro.schemas.ApiResponseModel;
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
    public CompletableFuture<ResponseEntity<ApiResponseModel<CustomerDto>>> addCustomer(@RequestBody @Valid CustomerCreateDto dto) {
        return this.service.createAsync(dto).thenApply(customerDto -> {
            var response = new ApiResponseModel<CustomerDto>();
            response.setModel(customerDto);
            response.setMessage("Created successfully.");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }).exceptionally(ex -> {
            var response = new ApiResponseModel<CustomerDto>();
            response.setModel(null);
            response.setMessage("Error: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        });
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<ApiResponseList<CustomerDto>>> getAllCustomers() {
        return service.getAllCustomersAsync().thenApply(list -> {
            var response = new ApiResponseList<CustomerDto>();
            response.setList(list);
            response.setMessage(null);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }).exceptionally(ex -> {
            var response = new ApiResponseList<CustomerDto>();
            response.setList(List.of());
            response.setMessage("Error: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        });
    }

    @GetMapping("/uuid/{uuid}")
    public String getCustomerByUuid(@PathVariable String uuid) {
        return "sfsf";
    }
}
