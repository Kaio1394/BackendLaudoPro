package com.kaiosantiago.laudopro.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false, unique = true)
    private UUID uuid;

    @Column(nullable = false)
    private String fantasyName;

    @Column(nullable = false, length = 14)
    private String cnpj;

    @Column(nullable = false, length = 18)
    private String cnpjFormated;

    @Column(nullable = false)
    private String address;

    public Customer() {
        this.uuid = UUID.randomUUID();
    }
}
