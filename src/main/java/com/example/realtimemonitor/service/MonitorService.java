package com.example.realtimemonitor.service;

import com.example.realtimemonitor.entity.Task;
import com.example.realtimemonitor.entity.TaskStatus;
import com.example.realtimemonitor.exception.ResourceNotFoundException;
import com.example.realtimemonitor.monitor.MonitorChecker;
import com.example.realtimemonitor.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MonitorService {

    private final TaskRepository taskRepository;
    private final MonitorChecker monitorChecker;

    public MonitorService(
            TaskRepository taskRepository,
            MonitorChecker monitorChecker
    ) {
        this.taskRepository = taskRepository;
        this.monitorChecker = monitorChecker;
    }

    public Task checkTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Task with id " + id + " does not exist"
                        )
                );

        task.setStatus(TaskStatus.RUNNING);
        task.setLastCheckTime(LocalDateTime.now());

        taskRepository.save(task);

        boolean success = monitorChecker.check(task);

        if (success) {
            task.setStatus(TaskStatus.SUCCESS);
        } else {
            task.setStatus(TaskStatus.FAILED);
        }

        return taskRepository.save(task);
    }

    public void checkAllTasks() {
        List<Task> tasks = taskRepository.findAll();

        LocalDateTime now = LocalDateTime.now();

        for (Task task : tasks) {
            if (shouldCheck(task, now)) {
                checkTask(task.getId());
            }
        }
    }

    private boolean shouldCheck(Task task, LocalDateTime now) {
        if (task.getLastCheckTime() == null) {
            return true;
        }

        long elapsedSeconds =
                Duration.between(
                        task.getLastCheckTime(),
                        now
                ).getSeconds();

        return elapsedSeconds >= task.getIntervalSeconds();
    }
}
