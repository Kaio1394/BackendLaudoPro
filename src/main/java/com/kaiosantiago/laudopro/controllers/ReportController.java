package com.kaiosantiago.laudopro.controllers;

import com.kaiosantiago.laudopro.services.ReportService;

public class ReportController {
    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }
}
