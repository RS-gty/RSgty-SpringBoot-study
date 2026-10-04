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

    @PostMapping("/result/{result}")
    public String setResult(@PathVariable MockResult result) {

        mockChecker.setResult(result);

        return "Mock result changed to " + result;
    }

    @GetMapping("/result")
    public MockResult getResult() {
        return mockChecker.getResult();
    }
}