package com.kaiosantiago.laudopro.services;

import com.kaiosantiago.laudopro.dtos.request.WorkOrderCreateRequest;
import com.kaiosantiago.laudopro.dtos.response.WorkOrderCreateResponse;
import com.kaiosantiago.laudopro.entity.WorkOrder;
import com.kaiosantiago.laudopro.exceptions.WorkOrderNumberAlreadyExists;
import com.kaiosantiago.laudopro.mapper.WorkOrderMapper;
import com.kaiosantiago.laudopro.repositories.WorkOrderRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class WorkOrderService {
    private final WorkOrderRepository repository;

    public WorkOrderService(WorkOrderRepository repository) {
        this.repository = repository;
    }

    @Async
    public CompletableFuture<WorkOrderCreateResponse> createAsync(WorkOrderCreateRequest dtoCreate){
        return CompletableFuture.supplyAsync(() -> {
            try{
                var model = WorkOrderMapper.workOrderCreateRequestToWorkOrder(dtoCreate);
                String workNumber = model.getWorkNumber();
                var existing = repository.findByWorkNumber(workNumber);
                if(existing.isPresent())
                    throw new WorkOrderNumberAlreadyExists("Worker order number already exists.");
                WorkOrder wo =  repository.save(model);
                return WorkOrderMapper.workOrderToWorkOrderCreateResponse(wo);
            }catch (Exception e){
                throw e;
            }
        });
    }
    @Async
    public CompletableFuture<List<WorkOrderCreateResponse>> getAll(){
        return CompletableFuture.supplyAsync(() ->
                this.repository.findAll()
                        .stream()
                        .map(WorkOrderMapper::workOrderToWorkOrderCreateResponse)
                        .toList()
        );
    }

    @Async
    public CompletableFuture<WorkOrderCreateResponse> getWorkOrderByNumber(String workNumber){
        return CompletableFuture.supplyAsync(() -> this.repository.findByWorkNumber(workNumber).map(WorkOrderMapper::workOrderToWorkOrderCreateResponse)
                .orElse(null));
    }

    @Async
    public CompletableFuture<List<WorkOrderCreateResponse>> getWorkOrderByIssueDate(LocalDate date){
        return CompletableFuture.supplyAsync(() ->
                repository.findByIssueDate(date)
                        .stream()
                        .map(WorkOrderMapper::workOrderToWorkOrderCreateResponse)
                        .toList()
        );
    }

    @Async
    public CompletableFuture<List<WorkOrderCreateResponse>> getWorkOrderByIssueDate(LocalDate dateIni, LocalDate dateEnd){
        return CompletableFuture.supplyAsync(() ->
            repository.findByIssueDateRange(dateIni, dateEnd)
                    .stream()
                    .map(WorkOrderMapper::workOrderToWorkOrderCreateResponse)
                    .toList()
        );
    }
}
