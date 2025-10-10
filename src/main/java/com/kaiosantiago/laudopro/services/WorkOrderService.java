package com.kaiosantiago.laudopro.services;

import com.kaiosantiago.laudopro.dtos.workOrder.WorkOrderCreateDto;
import com.kaiosantiago.laudopro.dtos.workOrder.WorkOrderDto;
import com.kaiosantiago.laudopro.entity.WorkOrder;
import com.kaiosantiago.laudopro.exceptions.WorkOrderNumberAlreadyExists;
import com.kaiosantiago.laudopro.mapper.customer.CustomerMapper;
import com.kaiosantiago.laudopro.mapper.workOrder.WorkOrderCreateDtoMapper;
import com.kaiosantiago.laudopro.mapper.workOrder.WorkOrderMapper;
import com.kaiosantiago.laudopro.repositories.WorkOrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class WorkOrderService {
    private final WorkOrderRepository repository;

    public WorkOrderService(WorkOrderRepository repository) {
        this.repository = repository;
    }

    @Async
    public CompletableFuture<WorkOrderDto> createAsync(WorkOrderCreateDto dtoCreate){
        return CompletableFuture.supplyAsync(() -> {
            try{
                var model = WorkOrderCreateDtoMapper.toWorkOrder(dtoCreate);
                String workNumber = model.getWorkNumber();
                var existing = repository.findByWorkNumber(workNumber);
                if(existing.isPresent())
                    throw new WorkOrderNumberAlreadyExists("Worker order number already exists.");
                WorkOrder wo =  repository.save(model);
                return WorkOrderMapper.toWorkOrderDto(wo);
            }catch (Exception e){
                throw e;
            }
        });
    }
    @Async
    public CompletableFuture<List<WorkOrderDto>> getAll(){
        return CompletableFuture.supplyAsync(() ->
                this.repository.findAll()
                        .stream()
                        .map(WorkOrderMapper::toWorkOrderDto)
                        .toList()
        );
    }

    @Async
    public CompletableFuture<WorkOrderDto> getWorkOrderByNumber(String workNumber){
        return CompletableFuture.supplyAsync(() -> this.repository.findByWorkNumber(workNumber).map(WorkOrderMapper::toWorkOrderDto)
                .orElse(null));
    }

    @Async
    public CompletableFuture<List<WorkOrderDto>> getWorkOrderByIssueDate(LocalDate date){
        return CompletableFuture.supplyAsync(() ->
                repository.findByIssueDate(date)
                        .stream()
                        .map(WorkOrderMapper::toWorkOrderDto)
                        .toList()
        );
    }

    @Async
    public CompletableFuture<List<WorkOrderDto>> getWorkOrderByIssueDate(LocalDate dateIni, LocalDate dateEnd){
        return CompletableFuture.supplyAsync(() ->
            repository.findByIssueDateRange(dateIni, dateEnd)
                    .stream()
                    .map(WorkOrderMapper::toWorkOrderDto)
                    .toList()
        );
    }
}
