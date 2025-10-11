package com.kaiosantiago.laudopro.schemas;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApiResponseModel<T> extends ApiResponseBase{
    private T model;
}
