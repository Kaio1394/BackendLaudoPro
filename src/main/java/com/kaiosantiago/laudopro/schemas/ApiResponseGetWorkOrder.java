package com.kaiosantiago.laudopro.schemas;

import com.kaiosantiago.laudopro.dtos.workOrder.WorkOrderDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApiResponseGetWorkOrder extends ApiResponseBase{
    private WorkOrderDto workOrder;
}