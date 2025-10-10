package com.kaiosantiago.laudopro.dtos.workOrder;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class WorkOrderCreateDto {
    private LocalDateTime calibrationDate;
    private LocalDateTime validateDate;
    private LocalDate issueDate;
}
