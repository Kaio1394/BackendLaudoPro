package com.kaiosantiago.laudopro.entity;

import com.kaiosantiago.laudopro.entity.base.BaseInstrument;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "safety_valve")
public class SafetyValve extends BaseInstrument {}
