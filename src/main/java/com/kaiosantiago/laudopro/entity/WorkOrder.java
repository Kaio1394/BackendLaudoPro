package com.kaiosantiago.laudopro.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "work_orders")
public class WorkOrder{
    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false, unique = true)
    private UUID uuid;

    @Column(nullable = false, unique = true, length = 24)
    private String workNumber;

    @Column
    private String description;

    @Column
    private LocalDateTime calibrationDate;

    @Column
    private LocalDateTime validateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDate issueDate;

    public WorkOrder(){
        this.uuid = UUID.randomUUID();
        this.workNumber = "WO-" + LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE)
                + "-" +
                this.getUuid().toString().substring(0, 8).toUpperCase();
    }
}
