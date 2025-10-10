package com.kaiosantiago.laudopro.schemas;

import com.kaiosantiago.laudopro.dtos.user.UserDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApiResponseCreateUser extends ApiResponseBase{
    private UserDto user;
}
