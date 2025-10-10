package com.kaiosantiago.laudopro.dtos.user;

import com.kaiosantiago.laudopro.entity.Plan;
import com.kaiosantiago.laudopro.entity.Role;
import lombok.Data;

@Data
public class UserCreateDto {
    private String name;
    private String email;
    private String password;
    private Long planId;
    private Long roleId;
}
