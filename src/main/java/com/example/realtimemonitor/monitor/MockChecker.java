package com.example.realtimemonitor.monitor;

import com.example.realtimemonitor.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class MockChecker implements MonitorChecker {

    @Override
    public boolean check(Task task) {
        return true;
    }
}