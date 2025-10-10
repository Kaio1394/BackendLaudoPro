package com.kaiosantiago.laudopro.dtos.user;

import com.kaiosantiago.laudopro.dtos.workOrder.WorkOrderDto;
import com.kaiosantiago.laudopro.entity.Plan;
import com.kaiosantiago.laudopro.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String uuid;
    private String name;
    private String email;
    private Long planId;
    private Long roleId;
    private List<WorkOrderDto> workOrders;
}
