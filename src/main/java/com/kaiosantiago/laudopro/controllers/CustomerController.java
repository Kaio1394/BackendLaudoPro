package com.kaiosantiago.laudopro.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @PostMapping("")
    public void addCustomer(){

    }

    @GetMapping
    public String getCustomer(){
        return "sfsf";
    }

    @GetMapping("/uuid/{uuid}")
    public String getCustomerByUuid(@PathVariable String uuid){
        return "sfsf";
    }

    @GetMapping("/cnpj/{cnpj}")
    public String getCustomerByCnpj(@PathVariable String cnpj){
        return "sfsf";
    }

    @GetMapping
    public String getCustomerByFantasyName(@RequestParam String fantasyName){
        return "sfsf";
    }
}
