package com.example.realtimemonitor.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MonitorExecutor {

    private final MonitorService monitorService;

    public MonitorExecutor(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @Async("monitorTaskExecutor")
    public void execute(Long taskId) {

        System.out.println(
                "Task " + taskId +
                        " executing on " +
                        Thread.currentThread().getName()
        );

        monitorService.checkTask(taskId);
    }
}