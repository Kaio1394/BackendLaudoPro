package com.kaiosantiago.laudopro.repositories;

import com.kaiosantiago.laudopro.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReportRepository extends JpaRepository<Report, UUID> {
}
