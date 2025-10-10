package com.kaiosantiago.laudopro.mapper.user;

import com.kaiosantiago.laudopro.dtos.user.UserCreateDto;
import com.kaiosantiago.laudopro.entity.User;

import java.util.List;

public class UserCreateDtoMapper {
    public static User toUser(UserCreateDto dto){
        var userModel = new User();
//        userModel.setEmail(dto.getEmail());
//        userModel.setRole(dto.get);
//        userModel.setPlan(dto.getPlanId());
//        userModel.setName(dto.getName());
//        userModel.setPassword(dto.getPassword());
//        userModel.setWorkOrders(List.of());
        return userModel;
    }
}
