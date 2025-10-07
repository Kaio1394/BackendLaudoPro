package com.kaiosantiago.laudopro.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CustomerDto {
    private UUID uuid;
    private String fantasyName;
    private String email;
    private String cnpj;
    private String cnpjFormated;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
