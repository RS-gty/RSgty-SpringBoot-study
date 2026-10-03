package com.example.realtimemonitor.service;

import com.example.realtimemonitor.dto.TaskCreateRequest;
import com.example.realtimemonitor.entity.Task;
import com.example.realtimemonitor.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(TaskCreateRequest request){
        Task task = new Task();

        task.setName(request.getName());
        task.setDescription(request.getDescription());
        task.setPriority(request.getPriority());

        return taskRepository.save(task);
    }


}
