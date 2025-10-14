package com.kaiosantiago.laudopro.repositories;

import com.kaiosantiago.laudopro.entity.SafetyValve;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SafetyValveRepository extends JpaRepository<SafetyValve, UUID> {
}
