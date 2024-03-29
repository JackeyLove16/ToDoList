package com.example.todolist.controller;

import com.example.todolist.model.Task;
import com.example.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/todolist") //port:8081
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTask(){
        return ResponseEntity.ok(taskService.getAllTask());
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getAllCompletedTask(){
        return ResponseEntity.ok(taskService.findAllCompletedTask());
    }
    @GetMapping("/incomplete")
    public ResponseEntity<List<Task>> getAllIncompleteTask(){
        return ResponseEntity.ok(taskService.findAllIncompleteTask());
    }
    @PostMapping("/")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return ResponseEntity.ok(taskService.updateTask(task));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> getAllTasks(@PathVariable Long id) {
        taskService.deleteTaskByID(id);
        return ResponseEntity.ok(true);
    }
    @GetMapping("/byTaskName")
    public ResponseEntity<Task> getTaskByTaskName(@RequestParam String taskName) {
        Optional<Task> task = taskService.findTaskByTaskName(taskName);

        return task.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
