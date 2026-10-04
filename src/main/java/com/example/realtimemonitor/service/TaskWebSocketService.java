package com.example.realtimemonitor.service;

import com.example.realtimemonitor.dto.TaskStatusMessage;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class TaskWebSocketService {

    private final SimpMessagingTemplate messagingTemplate;

    public TaskWebSocketService(
            SimpMessagingTemplate messagingTemplate
    ) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendTaskStatus(TaskStatusMessage message) {

        messagingTemplate.convertAndSend(
                "/topic/tasks",
                message
        );
    }
}