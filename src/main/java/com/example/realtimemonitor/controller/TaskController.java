package com.example.realtimemonitor.controller;

import com.example.realtimemonitor.dto.TaskCreateRequest;
import com.example.realtimemonitor.dto.TaskUpdateRequest;
import com.example.realtimemonitor.entity.CheckRecord;
import com.example.realtimemonitor.entity.Task;
import com.example.realtimemonitor.service.MonitorService;
import com.example.realtimemonitor.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private final TaskService taskService;
    private final MonitorService monitorService;

    public TaskController(
            TaskService taskService,
            MonitorService monitorService
    ) {
        this.taskService = taskService;
        this.monitorService = monitorService;
    }

    @PostMapping("/tasks")
    public Task postTasks(@Valid @RequestBody TaskCreateRequest request) {
        return this.taskService.createTask(request);
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskService.getTask(id);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable Long id, @Valid @RequestBody TaskUpdateRequest request) {
        return taskService.updateTask(id, request);
    }

    @PostMapping("/tasks/{id}/check")
    public Task checkTask(@PathVariable Long id) {
        return monitorService.checkTask(id);
    }

    @GetMapping("/tasks/{id}/records")
    public List<CheckRecord> getRecords(
            @PathVariable Long id
    ) {
        return taskService.getRecords(id);
    }
}
