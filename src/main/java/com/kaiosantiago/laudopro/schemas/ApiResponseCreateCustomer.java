package com.kaiosantiago.laudopro.schemas;

import com.kaiosantiago.laudopro.dtos.CustomerDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ApiResponseCreateCustomer extends ApiResponseBase {
    private CustomerDto customer;
}
