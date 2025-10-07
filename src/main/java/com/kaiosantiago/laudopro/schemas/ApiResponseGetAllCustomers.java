package com.kaiosantiago.laudopro.schemas;

import com.kaiosantiago.laudopro.dtos.CustomerReadDto;
import lombok.Data;

import java.util.List;

@Data
public class ApiResponseGetAllCustomers {
    private String message;
    private List<CustomerReadDto> listCustomers;
}
