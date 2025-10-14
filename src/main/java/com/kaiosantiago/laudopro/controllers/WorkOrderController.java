package com.kaiosantiago.laudopro.controllers;

import com.kaiosantiago.laudopro.dtos.request.WorkOrderCreateRequest;
import com.kaiosantiago.laudopro.dtos.response.WorkOrderCreateResponse;
import com.kaiosantiago.laudopro.response.ApiResponseList;
import com.kaiosantiago.laudopro.response.ApiResponseModel;
import com.kaiosantiago.laudopro.services.WorkOrderService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/workOrder")
public class WorkOrderController {
    private final WorkOrderService service;

    public WorkOrderController(WorkOrderService service) {
        this.service = service;
    }

    @GetMapping("/by-date")
    public CompletableFuture<ResponseEntity<ApiResponseList<WorkOrderCreateResponse>>> getWorkOrderByIssueDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateIni,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateEnd){

        CompletableFuture<List<WorkOrderCreateResponse>> future;
        if(dateEnd != null)
            future = service.getWorkOrderByIssueDate(dateIni, dateEnd);
        else
            future = service.getWorkOrderByIssueDate(dateIni);

        return future.thenApply(wo -> {
            var response = new ApiResponseList<WorkOrderCreateResponse>();
            response.setMessage(null);
            response.setList(wo);
            return ResponseEntity.ok(response);
        }).exceptionally(ex -> {
            var response = new ApiResponseList<WorkOrderCreateResponse>();
            response.setMessage("Error: " + ex.getMessage());
            response.setList(List.of());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        });
    }

    @GetMapping("/all")
    public CompletableFuture<ResponseEntity<ApiResponseList<WorkOrderCreateResponse>>> getAll(){
        var futureWorkOrderList = service.getAll();
        return futureWorkOrderList.thenApply(list -> {
            var response = new ApiResponseList<WorkOrderCreateResponse>();
            response.setList(list);
            response.setMessage(null);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }).exceptionally(ex -> {
            var response = new ApiResponseList<WorkOrderCreateResponse>();
            response.setMessage("Error: " + ex.getMessage());
            response.setList(List.of());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        });
    }

    @GetMapping("/{workNumber}")
    public CompletableFuture<ResponseEntity<ApiResponseModel<WorkOrderCreateResponse>>> getWorkOrderByNumber(@PathVariable String workNumber){
        var responseError = new ApiResponseModel<WorkOrderCreateResponse>();
        if(workNumber.isBlank()){
            responseError.setMessage("");
            responseError.setModel(null);
            return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError));
        }
        return this.service.getWorkOrderByNumber(workNumber).thenApply(wo -> {
            var response = new ApiResponseModel<WorkOrderCreateResponse>();
            response.setMessage("");
            response.setModel(wo);
            return ResponseEntity.ok(response);
        }).exceptionally(ex -> {
            var response = new ApiResponseModel<WorkOrderCreateResponse>();
            response.setMessage("Error: " + ex.getMessage());
            response.setModel(null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        });
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<ApiResponseModel<WorkOrderCreateResponse>>> create(@RequestBody @Valid WorkOrderCreateRequest dto){
        return service.createAsync(dto).thenApply(workOrder -> {
            var response = new ApiResponseModel<WorkOrderCreateResponse>();
            response.setModel(workOrder);
            response.setMessage("Created successfully.");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }).exceptionally(ex -> {
            var response = new ApiResponseModel<WorkOrderCreateResponse>();
            response.setModel(null);
            response.setMessage("Error: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        });
    }
}
