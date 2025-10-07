package com.kaiosantiago.laudopro.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerCreateDto {

    @NotBlank(message = "Nome fantasia é obrigatório")
    private String fantasyName;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "CNPJ é obrigatório")
    private String cnpj;

    @NotBlank(message = "CNPJ formatado é obrigatório")
    private String cnpjFormated;

    @NotBlank(message = "Endereço é obrigatório")
    private String address;
}
