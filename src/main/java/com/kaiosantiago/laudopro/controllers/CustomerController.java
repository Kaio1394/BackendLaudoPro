package com.kaiosantiago.laudopro.controllers;

import com.kaiosantiago.laudopro.dtos.CustomerCreateDto;
import com.kaiosantiago.laudopro.dtos.CustomerDto;
import com.kaiosantiago.laudopro.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public CompletableFuture<CustomerDto> addCustomer(@RequestBody @Valid CustomerCreateDto dto){
        return this.service.createAsync(dto);
    }

    @GetMapping
    public String getAllCustomers(){
        return "sfsf";
    }

    @GetMapping("/uuid/{uuid}")
    public String getCustomerByUuid(@PathVariable String uuid){
        return "sfsf";
    }
}
