package com.kaiosantiago.laudopro.controllers;

import com.kaiosantiago.laudopro.schemas.ApiResponseGetAllPlans;
import com.kaiosantiago.laudopro.services.PlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/plans")
public class PlanController {
    private final PlanService service;

    public PlanController(PlanService service) {
        this.service = service;
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<ApiResponseGetAllPlans>> getAll(){
        var future = service.getAll();
        return future.thenApply(list -> {
            var response = new ApiResponseGetAllPlans();
            response.setPlans(list);
            response.setMessage(null);
            return ResponseEntity.ok(response);
        }).exceptionally(ex -> {
            var response = new ApiResponseGetAllPlans();
            response.setPlans(List.of());
            response.setMessage("Error: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        });
    }

}
