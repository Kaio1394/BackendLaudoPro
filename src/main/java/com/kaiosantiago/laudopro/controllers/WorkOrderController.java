package com.kaiosantiago.laudopro.controllers;

import com.kaiosantiago.laudopro.schemas.ApiResponseCreatedWorkOrder;
import com.kaiosantiago.laudopro.schemas.ApiResponseGetAllWorkOrders;
import com.kaiosantiago.laudopro.services.WorkOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/workOrder")
public class WorkOrderController {
    private final WorkOrderService service;

    public WorkOrderController(WorkOrderService service) {
        this.service = service;
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<ApiResponseGetAllWorkOrders>> getAll(){
        var futureWorkOrderList = service.getAll();
        return futureWorkOrderList.thenApply(list -> {
            var response = new ApiResponseGetAllWorkOrders();
            response.setListWorkOrder(list);
            response.setMessage(null);
            return ResponseEntity.ok(response);
        }).exceptionally(ex -> {
            var response = new ApiResponseGetAllWorkOrders();
            response.setMessage("Error: " + ex.getMessage());
            response.setListWorkOrder(List.of());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        });
    }
}
