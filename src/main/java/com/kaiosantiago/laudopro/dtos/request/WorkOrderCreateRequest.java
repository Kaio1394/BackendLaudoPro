package com.kaiosantiago.laudopro.dtos.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class WorkOrderCreateRequest {
    private String userId;
    private String description;
    private LocalDateTime calibrationDate;
    private LocalDateTime validateDate;
    private LocalDate issueDate;
}
