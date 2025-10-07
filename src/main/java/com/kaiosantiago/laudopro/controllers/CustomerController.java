package com.kaiosantiago.laudopro.controllers;

import com.kaiosantiago.laudopro.dtos.CustomerCreateDto;
import com.kaiosantiago.laudopro.dtos.CustomerDto;
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
    public CompletableFuture<ApiResponseCreateCustomer> addCustomer(@RequestBody @Valid CustomerCreateDto dto) {
        ApiResponseCreateCustomer response = new ApiResponseCreateCustomer();
        try {
            CompletableFuture<CustomerDto> customer = this.service.createAsync(dto);
            return customer.thenApply(customerDto -> {
                response.setCustomer(customerDto);
                response.setMessage("Created successfully.");
                return response;
            }).exceptionally(ex -> {
                response.setCustomer(null);
                response.setMessage("Error: " + ex.getMessage());
                return response;
            });
        } catch (Exception e) {
            response.setCustomer(null);
            response.setMessage("Unexpected error: " + e.getMessage());
            return CompletableFuture.completedFuture(response);
        }
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<ApiResponseGetAllCustomers>> getAllCustomers() {
        ApiResponseGetAllCustomers response = new ApiResponseGetAllCustomers();
        return service.getAllCustomersAsync().thenApply(list -> {
            response.setListCustomers(list);
            response.setMessage(null);
            return ResponseEntity.ok(response);
        }).exceptionally(ex -> {
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
