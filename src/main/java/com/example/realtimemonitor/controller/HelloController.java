package com.example.realtimemonitor.controller;

import com.example.realtimemonitor.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final HelloService helloService;
    private long counter;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
        this.counter = 1;
    }

    @GetMapping("/hello")
    public String hello(){
        this.counter = this.counter << 1;
        return helloService.hello() + "\nid: " + this.counter;
    }
}
