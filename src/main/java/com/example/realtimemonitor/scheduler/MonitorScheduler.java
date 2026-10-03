package com.example.realtimemonitor.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MonitorScheduler {

    @Scheduled(fixedRate = 5000)
    public void testSchedule() {
        System.out.println("Scheduled task executed");
    }
}
