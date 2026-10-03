package com.example.realtimemonitor.scheduler;

import com.example.realtimemonitor.service.MonitorService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MonitorScheduler {

    private final MonitorService monitorService;

    public MonitorScheduler(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @Scheduled(fixedRate = 1000)
    public void checkTasks() {
        monitorService.checkAllTasks();
    }
}
