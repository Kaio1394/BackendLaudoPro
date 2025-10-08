package com.kaiosantiago.laudopro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "safety_valve")
public class SafetyValve extends BaseEntity {
    @Column(nullable = false, unique = true, length = 20)
    private String workNumber;

    @Column
    private LocalDateTime calibrationDate;

    @Column
    private LocalDateTime validateDate;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime issueDate;

    public SafetyValve(){
        this.workNumber = "WO-" + this.getUuid();
    }
}
