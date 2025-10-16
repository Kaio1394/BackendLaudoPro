package com.kaiosantiago.laudopro.dtos.response;

import lombok.Data;

@Data
public class UserResponse {
    private String uuid;
    private String name;
    private String email;
    private String username;
    private String password;
    private Long planId;
    private Long roleId;
}
