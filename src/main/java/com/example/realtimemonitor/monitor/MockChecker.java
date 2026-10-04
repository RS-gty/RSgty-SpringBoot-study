package com.example.realtimemonitor.monitor;

import com.example.realtimemonitor.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class MockChecker implements MonitorChecker {

    private MockResult result = MockResult.SUCCESS;

    @Override
    public boolean check(Task task) {

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

    public void setResult(MockResult result) {
        this.result = result;
    }

    public MockResult getResult() {
        return result;
    }
}