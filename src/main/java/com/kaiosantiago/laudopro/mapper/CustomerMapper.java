package com.kaiosantiago.laudopro.mapper;

import com.kaiosantiago.laudopro.dtos.request.CustomerCreateRequest;
import com.kaiosantiago.laudopro.dtos.response.CustomerCreateResponse;
import com.kaiosantiago.laudopro.entity.Customer;

public class CustomerMapper {
    public static CustomerCreateResponse customertToCustomerCreateResponse(Customer customer){
        var dto = new CustomerCreateResponse();
        dto.setUuid(customer.getUuid().toString());
        dto.setFantasyName(customer.getFantasyName());
        dto.setEmail(customer.getEmail());
        dto.setCnpj(customer.getCnpj());
        dto.setCnpjFormated(customer.getCnpjFormated());
        dto.setAddress(customer.getAddress());
        return dto;
    }
    public static Customer customerCreateRequestToCustomer(CustomerCreateRequest dto){
        var customer = new Customer();
        customer.setFantasyName(dto.getFantasyName());
        customer.setEmail(dto.getEmail());
        customer.setCnpj(dto.getCnpj());
        customer.setCnpjFormated(dto.getCnpjFormated());
        customer.setAddress(dto.getAddress());
        return customer;
    }
}
