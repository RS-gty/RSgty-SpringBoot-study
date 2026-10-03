package com.example.realtimemonitor.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Integer priority;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    public Task() {}

    public Task(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(TaskStatus taskStatus) {
        this.status = taskStatus;
    }

    public TaskStatus getStatus() {
        return status;
    }
}
