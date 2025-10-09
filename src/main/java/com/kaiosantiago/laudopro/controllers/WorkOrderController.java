package com.kaiosantiago.laudopro.controllers;

import com.kaiosantiago.laudopro.dtos.workOrder.WorkOrderCreateDto;
import com.kaiosantiago.laudopro.schemas.ApiResponseCreatedWorkOrder;
import com.kaiosantiago.laudopro.schemas.ApiResponseGetAllWorkOrders;
import com.kaiosantiago.laudopro.schemas.ApiResponseGetWorkOrder;
import com.kaiosantiago.laudopro.services.WorkOrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }).exceptionally(ex -> {
            var response = new ApiResponseGetAllWorkOrders();
            response.setMessage("Error: " + ex.getMessage());
            response.setListWorkOrder(List.of());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        });
    }

    @GetMapping("/{workNumber}")
    public CompletableFuture<ResponseEntity<ApiResponseGetWorkOrder>> getWorkOrderByNumber(@PathVariable String workNumber){
        var responseError = new ApiResponseGetWorkOrder();
        if(workNumber.isBlank()){
            responseError.setMessage("");
            responseError.setWorkOrder(null);
            return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError));
        }
        return this.service.getWorkOrderByNumber(workNumber).thenApply(wo -> {
            var response = new ApiResponseGetWorkOrder();
            response.setMessage("");
            response.setWorkOrder(wo);
            return ResponseEntity.ok(response);
        }).exceptionally(ex -> {
            var response = new ApiResponseGetWorkOrder();
            response.setMessage("Error: " + ex.getMessage());
            response.setWorkOrder(null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        });
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<ApiResponseCreatedWorkOrder>> create(@RequestBody @Valid WorkOrderCreateDto dto){
        return service.createAsync(dto).thenApply(workOrder -> {
            var response = new ApiResponseCreatedWorkOrder();
            response.setWorkOrder(workOrder);
            response.setMessage("Created successfully.");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }).exceptionally(ex -> {
            var response = new ApiResponseCreatedWorkOrder();
            response.setWorkOrder(null);
            response.setMessage("Error: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        });
    }
}
