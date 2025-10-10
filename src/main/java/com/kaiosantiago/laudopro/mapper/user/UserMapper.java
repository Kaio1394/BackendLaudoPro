package com.kaiosantiago.laudopro.mapper.user;

import com.kaiosantiago.laudopro.dtos.user.UserDto;
import com.kaiosantiago.laudopro.entity.User;
import com.kaiosantiago.laudopro.mapper.workOrder.WorkOrderMapper;

public class UserMapper {
    public static UserDto toUserDto(User user){
        var userDto = new UserDto();
        userDto.setUuid(user.getUuid().toString());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setPlanId(user.getPlan().getId());
        userDto.setRoleId(user.getRole().getId());
        userDto.setUuid(user.getUuid().toString());

        var listWorkOrdersDto = user.getWorkOrders().stream().map(WorkOrderMapper::toWorkOrderDto).toList();
        userDto.setWorkOrders(listWorkOrdersDto);
        return userDto;
    }
}
