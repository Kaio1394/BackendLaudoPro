package com.kaiosantiago.laudopro.schemas;

import com.kaiosantiago.laudopro.dtos.CustomerReadDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ApiResponseGetAllCustomers extends ApiResponseBase {
    private List<CustomerReadDto> listCustomers;
}
