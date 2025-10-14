package com.kaiosantiago.laudopro.response;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class ApiResponseBase {
    private String message;
}
