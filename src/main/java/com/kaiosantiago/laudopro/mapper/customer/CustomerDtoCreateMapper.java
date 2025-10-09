package com.kaiosantiago.laudopro.mapper.customer;

import com.kaiosantiago.laudopro.dtos.customer.CustomerCreateDto;
import com.kaiosantiago.laudopro.entity.Customer;

public class CustomerDtoCreateMapper {
    public static Customer toCustomer(CustomerCreateDto dto){
        var customer = new Customer();
        customer.setFantasyName(dto.getFantasyName());
        customer.setEmail(dto.getEmail());
        customer.setCnpj(dto.getCnpj());
        customer.setCnpjFormated(dto.getCnpjFormated());
        customer.setAddress(dto.getAddress());
        return customer;
    }
}
