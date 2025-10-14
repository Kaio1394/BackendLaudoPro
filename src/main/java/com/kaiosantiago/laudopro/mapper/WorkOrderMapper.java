package com.kaiosantiago.laudopro.mapper;

import com.kaiosantiago.laudopro.dtos.request.WorkOrderCreateRequest;
import com.kaiosantiago.laudopro.dtos.response.WorkOrderCreateResponse;
import com.kaiosantiago.laudopro.entity.WorkOrder;

public class WorkOrderMapper {
    public static WorkOrderCreateResponse workOrderToWorkOrderCreateResponse(WorkOrder model){
        var workOrderDto = new WorkOrderCreateResponse();
        workOrderDto.setDescription(model.getDescription());
        workOrderDto.setWorkNumber(model.getWorkNumber());
        workOrderDto.setUuid(model.getUuid().toString());
        workOrderDto.setCalibrationDate(model.getCalibrationDate());
        workOrderDto.setIssueDate(model.getIssueDate());
        workOrderDto.setValidateDate(model.getValidateDate());
        return workOrderDto;
    }

    public static WorkOrder workOrderCreateRequestToWorkOrder(WorkOrderCreateRequest dto){
        var model = new WorkOrder();
        model.setDescription(dto.getDescription());
        model.setCalibrationDate(dto.getCalibrationDate());
        model.setIssueDate(dto.getIssueDate());
        model.setValidateDate(dto.getValidateDate());
        return model;
    }
}
