package com.example.realtimemonitor.dto;

public class TaskStatisticsResponse {
    private Long taskId;

    private long totalChecks;

    private long successCount;

    private long failedCount;

    private double successRate;

    private double averageDuration;

    private Long minDuration;

    private Long maxDuration;

    public TaskStatisticsResponse(
            Long taskId,
            long totalChecks,
            long successCount,
            long failedCount,
            double successRate,
            double averageDuration,
            Long minDuration,
            Long maxDuration
    ) {
        this.taskId = taskId;
        this.totalChecks = totalChecks;
        this.successCount = successCount;
        this.failedCount = failedCount;
        this.successRate = successRate;
        this.averageDuration = averageDuration;
        this.minDuration = minDuration;
        this.maxDuration = maxDuration;
    }

    public Long getTaskId() {
        return taskId;
    }

    public long getTotalChecks() {
        return totalChecks;
    }

    public long getSuccessCount() {
        return successCount;
    }

    public long getFailedCount() {
        return failedCount;
    }

    public double getSuccessRate() {
        return successRate;
    }

    public double getAverageDuration() {
        return averageDuration;
    }

    public Long getMinDuration() {
        return minDuration;
    }

    public Long getMaxDuration() {
        return maxDuration;
    }
}
