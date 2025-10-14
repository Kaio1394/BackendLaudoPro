package com.kaiosantiago.laudopro.services;

import com.kaiosantiago.laudopro.repositories.SafetyValveRepository;
import org.springframework.stereotype.Service;

@Service
public class SafetyValveService {
    private final SafetyValveRepository repository;

    public SafetyValveService(SafetyValveRepository repository) {
        this.repository = repository;
    }
}
