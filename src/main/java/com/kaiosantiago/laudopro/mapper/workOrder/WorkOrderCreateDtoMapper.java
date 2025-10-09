package com.kaiosantiago.laudopro.mapper.workOrder;

import com.kaiosantiago.laudopro.dtos.workOrder.WorkOrderCreateDto;
import com.kaiosantiago.laudopro.entity.WorkOrder;

public class WorkOrderCreateDtoMapper {
    public static WorkOrder toWorkOrder(WorkOrderCreateDto dto){
        var model = new WorkOrder();
        model.setCalibrationDate(dto.getCalibrationDate());
        model.setIssueDate(dto.getIssueDate());
        model.setValidateDate(dto.getValidateDate());
        return model;
    }
}
