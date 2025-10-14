package com.kaiosantiago.laudopro.entity;

import com.kaiosantiago.laudopro.entity.base.BaseInstrument;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "pressure_gauge")
public class PressureGauge extends BaseInstrument {
    @Column(nullable = false)
    private String resolution;

    @Column(nullable = false)
    private String tolerance;
}
