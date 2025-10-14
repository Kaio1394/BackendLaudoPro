package com.kaiosantiago.laudopro.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApiResponseModel<T> extends ApiResponseBase{
    private T model;
}
