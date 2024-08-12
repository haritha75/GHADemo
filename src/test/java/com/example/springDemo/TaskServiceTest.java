package com.example.springDemo;

import com.example.springDemo.dao.TaskRepository;
import com.example.springDemo.models.Task;
import com.example.springDemo.services.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllTasks_ShouldReturnListOfTasks() {
        // Arrange
        Task task1 = new Task(1L, "Task 1", "Description 1", 50.0, 101L);
        Task task2 = new Task(2L, "Task 2", "Description 2", 75.0, 102L);
        List<Task> tasks = Arrays.asList(task1, task2);

        when(taskRepository.findAll()).thenReturn(tasks);

        // Act
        List<Task> result = taskService.getAllTasks();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Task 1", result.get(0).getTask_name());
        assertEquals("Task 2", result.get(1).getTask_name());
    }
}
