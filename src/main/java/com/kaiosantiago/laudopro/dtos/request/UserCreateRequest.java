package com.kaiosantiago.laudopro.dtos.request;

import lombok.Data;

@Data
public class UserCreateRequest {
    private String name;
    private String email;
    private String password;
    private Long planId;
    private Long roleId;
}
