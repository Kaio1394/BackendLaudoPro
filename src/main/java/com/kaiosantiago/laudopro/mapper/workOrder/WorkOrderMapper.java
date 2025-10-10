package com.kaiosantiago.laudopro.mapper.workOrder;

import com.kaiosantiago.laudopro.dtos.workOrder.WorkOrderDto;
import com.kaiosantiago.laudopro.entity.WorkOrder;

public class WorkOrderMapper {
    public static WorkOrderDto toWorkOrderDto(WorkOrder model){
        var workOrderDto = new WorkOrderDto();
        workOrderDto.setDescription(model.getDescription());
        workOrderDto.setWorkNumber(model.getWorkNumber());
        workOrderDto.setUuid(model.getUuid().toString());
        workOrderDto.setCalibrationDate(model.getCalibrationDate());
        workOrderDto.setIssueDate(model.getIssueDate());
        workOrderDto.setValidateDate(model.getValidateDate());
        return workOrderDto;
    }
}
