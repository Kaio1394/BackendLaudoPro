package com.kaiosantiago.laudopro.dtos.response;

import lombok.Data;

@Data
public class UserCreateResponse {
    private String uuid;
    private String name;
    private String email;
    private String username;
    private Long planId;
    private Long roleId;
}
