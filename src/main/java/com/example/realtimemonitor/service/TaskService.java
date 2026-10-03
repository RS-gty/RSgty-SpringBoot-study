package com.example.realtimemonitor.service;

import com.example.realtimemonitor.dto.TaskCreateRequest;
import com.example.realtimemonitor.dto.TaskUpdateRequest;
import com.example.realtimemonitor.entity.Task;
import com.example.realtimemonitor.entity.TaskStatus;
import com.example.realtimemonitor.exception.ResourceNotFoundException;
import com.example.realtimemonitor.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        task.setStatus(TaskStatus.PENDING);

        return taskRepository.save(task);
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTask(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            return task.get();
        } else {
            throw new ResourceNotFoundException("Task with id " + id + " does not exist");
        }
    }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Task with id " + id + " does not exist"
            );
        }

        taskRepository.deleteById(id);
    }

    public Task updateTask(Long id, TaskUpdateRequest request){
        Optional<Task> taskOptional = taskRepository.findById(id);

        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setName(request.getName());
            task.setDescription(request.getDescription());
            task.setPriority(request.getPriority());
            return taskRepository.save(task);
        } else {
            throw new ResourceNotFoundException("Task with id " + id + " does not exist");
        }
    }
}
