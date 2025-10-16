package com.kaiosantiago.laudopro.mapper;

import com.kaiosantiago.laudopro.dtos.response.UserCreateResponse;
import com.kaiosantiago.laudopro.dtos.response.UserResponse;
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
    public static UserResponse userToUserResponse(User user){
        var userDto = new UserResponse();
        userDto.setUuid(user.getUuid().toString());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());
        userDto.setPlanId(user.getPlan().getId());
        userDto.setRoleId(user.getRole().getId());
        return userDto;
    }
    public static UserCreateResponse userResponseToUserCreateResponse(UserResponse user){
        var userDto = new UserCreateResponse();
        userDto.setUuid(user.getUuid());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setPlanId(user.getPlanId());
        userDto.setRoleId(user.getRoleId());
        return userDto;
    }
}
