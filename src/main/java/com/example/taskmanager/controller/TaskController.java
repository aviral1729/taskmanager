package com.example.taskmanager.controller;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.Service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Map<String, Object> taskData) {
        Long userId = Long.valueOf(taskData.get("userId").toString());
        Task task = new Task();
        task.setTitle((String) taskData.get("title"));
        task.setDescription((String) taskData.get("description"));
        task.setStatus((String) taskData.get("status"));

        Task createdTask = taskService.createTask(task, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @GetMapping("/tasks/users/{userId}")
    public ResponseEntity<List<Task>> getAllTasksByUserId(@PathVariable Long userId) {
        List<Task> tasks = taskService.getAllTasksByUserId(userId);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{taskId}/user/{userId}")
    public ResponseEntity<Task> getTaskByIdAndUserId(@PathVariable Long taskId, @PathVariable Long userId) {
        Task task = taskService.getTaskByIdAndUserId(taskId, userId);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        Task updatedTask = taskService.updateTask(id, taskDetails);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}

