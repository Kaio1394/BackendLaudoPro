package com.kaiosantiago.laudopro.schemas;

import com.kaiosantiago.laudopro.dtos.workOrder.WorkOrderDto;
import lombok.Data;

import java.util.List;

@Data
public class ApiResponseGetAllWorkOrders extends ApiResponseBase{
    private List<WorkOrderDto> listWorkOrder;
}
