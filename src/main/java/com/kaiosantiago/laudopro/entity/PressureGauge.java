package com.kaiosantiago.laudopro.entity;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PressureGauge extends InstrumentBase{
    @Column(nullable = false)
    private String resolution;

    @Column(nullable = false)
    private String tolerance;
}
