package com.kaiosantiago.laudopro.mapper;

import com.kaiosantiago.laudopro.dtos.response.UserCreateResponse;
import com.kaiosantiago.laudopro.entity.User;

public class UserMapper {
    public static UserCreateResponse userToUserCreateResponse(User user){
        var userDto = new UserCreateResponse();
        userDto.setUuid(user.getUuid().toString());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setPlanId(user.getPlan().getId());
        userDto.setRoleId(user.getRole().getId());
        userDto.setUuid(user.getUuid().toString());
        return userDto;
    }
}
