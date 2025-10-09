package com.kaiosantiago.laudopro.schemas;

import com.kaiosantiago.laudopro.dtos.customer.CustomerDto;
import com.kaiosantiago.laudopro.dtos.customer.CustomerReadDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ApiResponseGetAllCustomers extends ApiResponseBase {
    private List<CustomerDto> listCustomers;
}
