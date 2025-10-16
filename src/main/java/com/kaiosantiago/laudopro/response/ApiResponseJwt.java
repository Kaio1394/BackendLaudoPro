package com.kaiosantiago.laudopro.response;

import com.kaiosantiago.laudopro.dtos.response.UserCreateResponse;
import com.kaiosantiago.laudopro.dtos.response.UserResponse;
import lombok.Data;

@Data
public class ApiResponseJwt {
    private String token;
    private String type;
    private int expiresIn;
    private UserCreateResponse user;
    private String message;
}
