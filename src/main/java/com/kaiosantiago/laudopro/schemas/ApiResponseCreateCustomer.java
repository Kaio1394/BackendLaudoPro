package com.kaiosantiago.laudopro.schemas;

import com.kaiosantiago.laudopro.dtos.CustomerDto;
import lombok.Data;

@Data
public class ApiResponseCreateCustomer {
    private String message;
    private CustomerDto customer;
}
