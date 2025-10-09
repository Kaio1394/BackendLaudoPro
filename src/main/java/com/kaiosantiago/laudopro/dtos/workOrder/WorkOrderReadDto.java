package com.kaiosantiago.laudopro.dtos.workOrder;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WorkOrderReadDto {
    private String workNumber;
    private LocalDateTime calibrationDate;
    private LocalDateTime validateDate;
    private LocalDateTime issueDate;
}
