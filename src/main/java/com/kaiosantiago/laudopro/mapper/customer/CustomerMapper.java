package com.kaiosantiago.laudopro.mapper.customer;

import com.kaiosantiago.laudopro.dtos.CustomerDto;
import com.kaiosantiago.laudopro.dtos.CustomerReadDto;
import com.kaiosantiago.laudopro.entity.Customer;

public class CustomerMapper {
    public static CustomerDto toCustomerDto(Customer customer){
        var dto = new CustomerDto();
        dto.setUuid(customer.getUuid().toString());
        dto.setFantasyName(customer.getFantasyName());
        dto.setUpdatedAt(customer.getUpdatedAt());
        dto.setCreatedAt(customer.getCreatedAt());
        dto.setEmail(customer.getEmail());
        dto.setCnpj(customer.getCnpj());
        dto.setCnpjFormated(customer.getCnpjFormated());
        dto.setAddress(customer.getAddress());
        return dto;
    }
    public static CustomerReadDto toCustomerReadDto(Customer customer){
        var dto = new CustomerReadDto();
        dto.setFantasyName(customer.getFantasyName());
        dto.setUpdatedAt(customer.getUpdatedAt());
        dto.setCreatedAt(customer.getCreatedAt());
        dto.setEmail(customer.getEmail());
        dto.setCnpj(customer.getCnpj());
        dto.setCnpjFormated(customer.getCnpjFormated());
        dto.setAddress(customer.getAddress());
        return dto;
    }
}
