package com.example.realtimemonitor.monitor;

import com.example.realtimemonitor.entity.Task;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MockChecker implements MonitorChecker {

    private final Map<Long, MockResult> results = new ConcurrentHashMap<>();

    @Override
    public boolean check(Task task) {

        MockResult result = results.getOrDefault(
                task.getId(),
                MockResult.SUCCESS
        );

        return switch (result) {
            case SUCCESS -> true;
            case FAILED -> false;
            case DELAY -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    yield false;
                }
                yield true;
            }
            case TIMEOUT -> {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    yield false;
                }
                yield false;
            }
            default -> false;
        };
    }

    public void setResult(Long taskId, MockResult result) {
        results.put(taskId, result);
    }

    public MockResult getResult(Long taskId) {
        return results.getOrDefault(
                taskId,
                MockResult.SUCCESS
        );
    }
}