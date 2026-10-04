package com.example.realtimemonitor.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncMonitorService {

    private final MonitorService monitorService;

    public AsyncMonitorService(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @Async("monitorTaskExecutor")
    public void checkTaskAsync(Long taskId) {
        monitorService.checkTask(taskId);
    }
}