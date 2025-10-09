package com.kaiosantiago.laudopro.repositories;

import com.kaiosantiago.laudopro.entity.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, UUID> {
    Optional<WorkOrder> findByWorkNumber(String workNumber);
}
