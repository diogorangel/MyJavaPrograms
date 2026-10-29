package com.exemplo.taskmanager.service;

import com.exemplo.taskmanager.controller.dto.TaskRequestDTO;
import com.exemplo.taskmanager.controller.dto.TaskResponseDTO;
import com.exemplo.taskmanager.model.Task;
import com.exemplo.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional
    public TaskResponseDTO create(TaskRequestDTO dto) {
        Task task = new Task(dto.title(), dto.description());
        Task savedTask = taskRepository.save(task);
        return TaskResponseDTO.fromEntity(savedTask);
    }

    @Transactional(readOnly = true)
    public List<TaskResponseDTO> findAll() {
        return taskRepository.findAll().stream()
                .map(TaskResponseDTO::fromEntity)
                .toList();
    }

    @Transactional(readOnly = true)
    public TaskResponseDTO findById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada com ID: " + id));
        return TaskResponseDTO.fromEntity(task);
    }

    @Transactional
    public TaskResponseDTO updateStatus(Long id, Task.TaskStatus newStatus) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada com ID: " + id));
        task.setStatus(newStatus);
        return TaskResponseDTO.fromEntity(task);
    }
}