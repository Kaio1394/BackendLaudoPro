package com.kaiosantiago.laudopro.controllers;

import com.kaiosantiago.laudopro.services.SafetyValveService;

public class SafetyController {
    private final SafetyValveService service;

    public SafetyController(SafetyValveService service) {
        this.service = service;
    }
}
