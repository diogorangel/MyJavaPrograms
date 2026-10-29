package com.exemplo.taskmanager.controller.dto;

import com.exemplo.taskmanager.model.Task;

import java.time.LocalDateTime;

public record TaskResponseDTO(
    Long id,
    String title,
    String description,
    Task.TaskStatus status,
    LocalDateTime createdAt
) {
    public static TaskResponseDTO fromEntity(Task task) {
        return new TaskResponseDTO(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getStatus(),
            task.getCreatedAt()
        );
    }
}