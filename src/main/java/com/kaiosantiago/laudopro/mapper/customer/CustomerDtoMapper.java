package com.kaiosantiago.laudopro.mapper.customer;

import com.kaiosantiago.laudopro.entity.Customer;
import com.kaiosantiago.laudopro.dtos.customer.CustomerDto;

public class CustomerDtoMapper {
    public static Customer toCustomer(CustomerDto dto){
        var customer = new Customer();
        customer.setFantasyName(dto.getFantasyName());
        customer.setEmail(dto.getEmail());
        customer.setCnpj(dto.getCnpj());
        customer.setCnpjFormated(dto.getCnpjFormated());
        customer.setAddress(dto.getAddress());
        return customer;
    }
}
