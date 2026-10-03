package com.example.realtimemonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RealtimeMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(RealtimeMonitorApplication.class, args);
    }

}
