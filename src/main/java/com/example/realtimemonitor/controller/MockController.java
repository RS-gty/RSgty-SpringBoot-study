package com.example.realtimemonitor.controller;

import com.example.realtimemonitor.monitor.MockChecker;
import com.example.realtimemonitor.monitor.MockResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mock")
public class MockController {

    private final MockChecker mockChecker;

    public MockController(MockChecker mockChecker) {
        this.mockChecker = mockChecker;
    }

    @PostMapping("/{taskId}/result/{result}")
    public String setResult(
            @PathVariable Long taskId,
            @PathVariable MockResult result
    ) {

        mockChecker.setResult(taskId, result);

        return "Task " + taskId +
                " mock result changed to " + result;
    }

    @GetMapping("/{taskId}/result")
    public MockResult getResult(
            @PathVariable Long taskId
    ) {
        return mockChecker.getResult(taskId);
    }
}