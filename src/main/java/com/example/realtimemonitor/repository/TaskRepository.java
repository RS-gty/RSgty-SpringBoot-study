package com.example.realtimemonitor.repository;

import com.example.realtimemonitor.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
