package com.kaiosantiago.laudopro.entity.base;

import com.kaiosantiago.laudopro.entity.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public abstract class BaseInstrument extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(length = 100)
    private String description;

    @Column(nullable = false, unique = true)
    private String tag;

    @Column(nullable = false)
    private String manufacturer;

    @Column private String serialNumber;

    @Column private String model;

    @Column private String size;

    @Column private String actuationRange;
}
