package com.kaiosantiago.laudopro.dtos.customer;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerReadDto {
    private String fantasyName;
    private String email;
    private String cnpj;
    private String cnpjFormated;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}