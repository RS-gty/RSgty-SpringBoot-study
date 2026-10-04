package com.example.realtimemonitor.service;

import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RunningTaskManager {

    private final Set<Long> runningTasks =
            ConcurrentHashMap.newKeySet();

    public boolean tryStart(Long taskId) {
        return runningTasks.add(taskId);
    }

    public void finish(Long taskId) {
        runningTasks.remove(taskId);
    }

    public boolean isRunning(Long taskId) {
        return runningTasks.contains(taskId);
    }
}