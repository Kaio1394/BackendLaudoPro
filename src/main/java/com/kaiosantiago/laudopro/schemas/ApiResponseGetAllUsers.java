package com.kaiosantiago.laudopro.schemas;

import com.kaiosantiago.laudopro.dtos.user.UserDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApiResponseGetAllUsers extends ApiResponseBase {
    List<UserDto> users;
}
