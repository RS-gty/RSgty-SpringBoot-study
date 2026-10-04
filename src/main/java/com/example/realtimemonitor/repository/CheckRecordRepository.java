package com.example.realtimemonitor.repository;

import com.example.realtimemonitor.entity.CheckRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckRecordRepository
        extends JpaRepository<CheckRecord, Long> {
}