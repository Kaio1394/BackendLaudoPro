package com.kaiosantiago.laudopro.dtos.workOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class WorkOrderDto {
    private String uuid;
    private String workNumber;
    private LocalDateTime calibrationDate;
    private LocalDateTime validateDate;
    private LocalDateTime issueDate;
}
