package com.kaiosantiago.laudopro.controllers;

import com.kaiosantiago.laudopro.dtos.request.CustomerCreateRequest;
import com.kaiosantiago.laudopro.dtos.response.CustomerCreateResponse;
import com.kaiosantiago.laudopro.response.ApiResponseList;
import com.kaiosantiago.laudopro.response.ApiResponseModel;
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
    public CompletableFuture<ResponseEntity<ApiResponseModel<CustomerCreateResponse>>> addCustomer(@RequestBody @Valid CustomerCreateRequest dto) {
        return this.service.createAsync(dto).thenApply(customerDto -> {
            var response = new ApiResponseModel<CustomerCreateResponse>();
            response.setModel(customerDto);
            response.setMessage("Created successfully.");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }).exceptionally(ex -> {
            var response = new ApiResponseModel<CustomerCreateResponse>();
            response.setModel(null);
            response.setMessage("Error: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        });
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<ApiResponseList<CustomerCreateResponse>>> getAllCustomers() {
        return service.getAllCustomersAsync().thenApply(list -> {
            var response = new ApiResponseList<CustomerCreateResponse>();
            response.setList(list);
            response.setMessage(null);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }).exceptionally(ex -> {
            var response = new ApiResponseList<CustomerCreateResponse>();
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
