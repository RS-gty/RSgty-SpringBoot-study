package com.example.realtimemonitor.scheduler;

import com.example.realtimemonitor.entity.Task;
import com.example.realtimemonitor.service.MonitorExecutor;
import com.example.realtimemonitor.repository.TaskRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class MonitorScheduler {

    private final TaskRepository taskRepository;
    private final MonitorExecutor monitorExecutor;

    public MonitorScheduler(
            TaskRepository taskRepository,
            MonitorExecutor monitorExecutor
    ) {
        this.taskRepository = taskRepository;
        this.monitorExecutor = monitorExecutor;
    }

    @Scheduled(fixedRate = 1000)
    public void checkTasks() {

        List<Task> tasks = taskRepository.findAll();

        LocalDateTime now = LocalDateTime.now();

        for (Task task : tasks) {

            if (shouldCheck(task, now)) {

                monitorExecutor.execute(task.getId());
            }
        }
    }

    private boolean shouldCheck(
            Task task,
            LocalDateTime now
    ) {

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