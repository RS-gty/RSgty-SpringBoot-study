package com.example.realtimemonitor.repository;

import com.example.realtimemonitor.entity.CheckRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckRecordRepository
        extends JpaRepository<CheckRecord, Long> {

    List<CheckRecord> findByTaskId(Long taskId);
}