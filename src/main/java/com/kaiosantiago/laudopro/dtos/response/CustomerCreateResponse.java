package com.kaiosantiago.laudopro.dtos.response;

import lombok.Data;

@Data
public class CustomerCreateResponse {
    private String uuid;
    private String fantasyName;
    private String email;
    private String cnpj;
    private String cnpjFormated;
    private String address;
}
