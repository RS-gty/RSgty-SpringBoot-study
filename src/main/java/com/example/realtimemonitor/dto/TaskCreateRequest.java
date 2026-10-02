package com.example.realtimemonitor.dto;

import jakarta.validation.constraints.*;

public class TaskCreateRequest {
    @NotBlank
    @Size(max = 100)
    private String name;

    private String description;

    @NotNull
    @Min(1)
    @Max(5)
    private Integer priority;


    public TaskCreateRequest() {}

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
