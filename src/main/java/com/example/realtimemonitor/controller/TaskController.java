package com.example.realtimemonitor.controller;

import com.example.realtimemonitor.dto.TaskCreateRequest;
import com.example.realtimemonitor.dto.TestRequest;
import com.example.realtimemonitor.entity.Task;
import com.example.realtimemonitor.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/tasks")
    public Task postTasks(@Valid @RequestBody TaskCreateRequest request) {
        return this.taskService.createTask(request);
    }
}
