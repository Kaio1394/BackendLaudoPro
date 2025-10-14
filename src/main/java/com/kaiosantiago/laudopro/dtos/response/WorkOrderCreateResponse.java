package com.kaiosantiago.laudopro.dtos.response;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class WorkOrderCreateResponse {
    private String uuid;
    private String workNumber;
    private String description;
    private LocalDateTime calibrationDate;
    private LocalDateTime validateDate;
    private LocalDate issueDate;
}
