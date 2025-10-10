package com.kaiosantiago.laudopro.schemas;

import com.kaiosantiago.laudopro.entity.Plan;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApiResponseGetAllPlans extends ApiResponseBase{
    private List<Plan> plans;
}
