package com.kaiosantiago.laudopro.services;

import com.kaiosantiago.laudopro.entity.Plan;
import com.kaiosantiago.laudopro.repositories.PlanRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class PlanService {
    private final PlanRepository repository;

    public PlanService(PlanRepository repository) {
        this.repository = repository;
    }

    @Async
    public CompletableFuture<List<Plan>> getAll(){
        return CompletableFuture.supplyAsync(repository::findAll);
    }

    @Async
    public CompletableFuture<Plan> getPlanById(Long id){
        return CompletableFuture.supplyAsync(() -> repository.findById(id).orElse(null));
    }
}
