package com.example.realtimemonitor.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MonitorExecutor {

    private final MonitorService monitorService;
    private final RunningTaskManager runningTaskManager;

    public MonitorExecutor(
            MonitorService monitorService,
            RunningTaskManager runningTaskManager
    ) {
        this.monitorService = monitorService;
        this.runningTaskManager = runningTaskManager;
    }

    @Async("monitorTaskExecutor")
    public void execute(Long taskId) {

        if (!runningTaskManager.tryStart(taskId)) {
            System.out.println(
                    "Task " + taskId + " is already running"
            );
            return;
        }

        try {

            System.out.println(
                    "Task " + taskId +
                            " executing on " +
                            Thread.currentThread().getName()
            );

            monitorService.checkTask(taskId);

        } finally {

            runningTaskManager.finish(taskId);
        }
    }
}