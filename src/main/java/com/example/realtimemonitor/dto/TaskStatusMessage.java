package com.example.realtimemonitor.dto;

public class TaskStatusMessage {

    private Long taskId;
    private String status;
    private Long duration;
    private String result;

    public TaskStatusMessage() {
    }

    public TaskStatusMessage(
            Long taskId,
            String status,
            Long duration,
            String result
    ) {
        this.taskId = taskId;
        this.status = status;
        this.duration = duration;
        this.result = result;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}