package com.example.realtimemonitor.service;

import com.example.realtimemonitor.dto.TaskCreateRequest;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    public String createTask(TaskCreateRequest request){
        return "Task created: " + request.getName();
    }
}
