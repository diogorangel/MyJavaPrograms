package com.exemplo.taskmanager.service;

import com.exemplo.taskmanager.controller.dto.TaskRequestDTO;
import com.exemplo.taskmanager.controller.dto.TaskResponseDTO;
import com.exemplo.taskmanager.model.Task;
import com.exemplo.taskmanager.repository.TaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    @DisplayName("Deve criar uma tarefa com sucesso")
    void shouldCreateTaskSuccessfully() {
        TaskRequestDTO request = new TaskRequestDTO("Nova Tarefa", "Descrição de teste");
        Task savedTask = new Task("Nova Tarefa", "Descrição de teste");

        when(taskRepository.save(any(Task.class))).thenReturn(savedTask);

        TaskResponseDTO response = taskService.create(request);

        assertNotNull(response);
        assertEquals("Nova Tarefa", response.title());
        assertEquals(Task.TaskStatus.PENDING, response.status());
        verify(taskRepository, times(1)).save(any(Task.class));
    }
}