package com.example.Seminar5homework.controller;

import com.example.Seminar5homework.model.Task;
import com.example.Seminar5homework.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping()
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

//    @GetMapping()
//    public ResponseEntity<List<Task>> getAllTasks() {
//        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
//    }

    @PostMapping() public Task addTask(@RequestBody Task task){
        task.setDatetime(LocalDateTime.now());
        return  taskService.createTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        taskService.deleteTask(id);
        return taskService.createTask(task);
    }


    @GetMapping("/{id}")
    public Optional<Task> getById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }




}