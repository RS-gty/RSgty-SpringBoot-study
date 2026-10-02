package com.example.realtimemonitor.controller;

import com.example.realtimemonitor.dto.TestRequest;
import com.example.realtimemonitor.service.TestService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/hello")
    public String getHello() {
        return testService.hello();
    }

    @PostMapping("/hello")
    public String postHello(@RequestBody String message) {
        return "POST: " + message;
    }

    @PostMapping("/json")
    public String postJson(@RequestBody TestRequest request) {
        return "name=" + request.getName()
                + ", age=" + request.getAge();
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable long id) {
        return "User ID: " + id;
    }

    @GetMapping("/search")
    public String getSearch(@RequestParam String name, @RequestParam Integer age) {
        return testService.createMessage("name="+ name + ", age=" + age);
    }
}
