package com.kaiosantiago.laudopro.repositories;

import com.kaiosantiago.laudopro.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
