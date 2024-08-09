package com.example.springDemo.controllers;

import com.example.springDemo.models.Task;
import com.example.springDemo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return new ResponseEntity<>(taskService.addTask(task),HttpStatus.CREATED);
    }
    @GetMapping("/{task_id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long task_id){
        return new ResponseEntity<>(taskService.getTaskById(task_id).get(),HttpStatus.OK);
    }
    @PutMapping("/{task_id}")
    public ResponseEntity<Task> updateTaskById(@RequestBody Task task,@PathVariable Long task_id){
        return new ResponseEntity<Task>(taskService.updateTask(task),HttpStatus.OK);

    }
    @DeleteMapping("/{task_id}")
    public ResponseEntity<Task> deleteTaskById(@PathVariable Long task_id){
        return new ResponseEntity<Task>(taskService.deleteTask(task_id),HttpStatus.OK);
    }


}
