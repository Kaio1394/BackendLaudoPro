package com.kaiosantiago.laudopro.repositories;

import com.kaiosantiago.laudopro.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
