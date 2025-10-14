package com.kaiosantiago.laudopro.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApiResponseList<T> extends ApiResponseBase {
    private List<T> list;
}
