package com.kaiosantiago.laudopro.services;

import com.kaiosantiago.laudopro.repositories.ReportRepository;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    private final ReportRepository repository;

    public ReportService(ReportRepository repository) {
        this.repository = repository;
    }
}
