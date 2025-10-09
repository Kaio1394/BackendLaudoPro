package com.kaiosantiago.laudopro.dtos.customer;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerDto {
    private String uuid;
    private String fantasyName;
    private String email;
    private String cnpj;
    private String cnpjFormated;
    private String address;
}
