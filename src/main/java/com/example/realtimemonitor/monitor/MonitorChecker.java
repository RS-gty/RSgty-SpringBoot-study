package com.example.realtimemonitor.monitor;

import com.example.realtimemonitor.entity.Task;

public interface MonitorChecker {

    boolean check(Task task);
}