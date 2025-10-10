package com.kaiosantiago.laudopro.repositories;

import com.kaiosantiago.laudopro.entity.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, UUID> {
    Optional<WorkOrder> findByWorkNumber(String workNumber);
    List<WorkOrder> findByIssueDate(LocalDate issueDate);

    @Query("SELECT w FROM WorkOrder w WHERE w.issueDate >= :dateIni AND w.issueDate < :dateEnd")
    List<WorkOrder> findByIssueDateRange(@Param("dateIni") LocalDate dateIni, @Param("dateEnd") LocalDate dateEnd);
}
