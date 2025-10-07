package com.kaiosantiago.laudopro.services;

import com.kaiosantiago.laudopro.dtos.CustomerCreateDto;
import com.kaiosantiago.laudopro.dtos.CustomerDto;
import com.kaiosantiago.laudopro.dtos.CustomerReadDto;
import com.kaiosantiago.laudopro.entity.Customer;
import com.kaiosantiago.laudopro.repositories.CustomerRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Async
    public CompletableFuture<List<CustomerReadDto>> getAllCustomersAsync(){
        var listCustomerDto = this.customerRepository.findAll()
                .stream().map(customer -> {
                    CustomerReadDto dto = new CustomerReadDto();
                    dto.setFantasyName(customer.getFantasyName());
                    dto.setCnpj(customer.getCnpj());
                    dto.setCnpjFormated(customer.getCnpjFormated());
                    dto.setAddress(customer.getAddress());
                    dto.setEmail(customer.getEmail());
                    dto.setCreatedAt(customer.getCreatedAt());
                    dto.setUpdatedAt(customer.getUpdatedAt());

                    return dto;
                }).toList();
        return CompletableFuture.completedFuture(listCustomerDto);
    }

    @Async
    public CompletableFuture<CustomerDto> createAsync(CustomerCreateDto dtoCreate){
        try {
            Customer customer = new Customer();
            customer.setFantasyName(dtoCreate.getFantasyName());
            customer.setEmail(dtoCreate.getEmail());
            customer.setCnpj(dtoCreate.getCnpj());
            customer.setCnpjFormated(dtoCreate.getCnpjFormated());
            customer.setAddress(dtoCreate.getAddress());

            Customer save = customerRepository.save(customer);

            CustomerDto response = new CustomerDto();
            response.setUuid(save.getUuid());
            response.setFantasyName(save.getFantasyName());
            response.setEmail(save.getEmail());
            response.setCnpj(save.getCnpj());
            response.setCnpjFormated(save.getCnpjFormated());
            response.setAddress(save.getAddress());
            response.setCreatedAt(save.getCreatedAt());
            response.setUpdatedAt(save.getUpdatedAt());

            return CompletableFuture.completedFuture(response);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar Customer: " + e.getMessage());
        }
    }
}
