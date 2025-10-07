package com.kaiosantiago.laudopro.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "customer")
public class Customer extends BaseEntity{
    @Column(nullable = false, unique = true)
    private String fantasyName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 14, unique = true)
    private String cnpj;

    @Column(nullable = false, length = 18, unique = true)
    private String cnpjFormated;

    @Column(nullable = false)
    private String address;
}
