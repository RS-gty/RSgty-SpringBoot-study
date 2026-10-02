package com.example.realtimemonitor.entity;

import java.time.LocalDateTime;

public class Task {
    private Long id;

    private String name;

    private String description;

    private TaskStatus status;

    private Integer priority;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    public Task() {}

    public Task(String name) {
        this.name = name;
    }




}
