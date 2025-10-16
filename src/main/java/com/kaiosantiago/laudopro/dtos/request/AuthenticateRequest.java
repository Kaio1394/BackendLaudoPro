package com.kaiosantiago.laudopro.dtos.request;

import lombok.Data;

@Data
public class AuthenticateRequest {
    private String username;
    private String password;
}
