package com.kaiosantiago.laudopro.schemas;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class ApiResponseBase {
    private String message;
}
