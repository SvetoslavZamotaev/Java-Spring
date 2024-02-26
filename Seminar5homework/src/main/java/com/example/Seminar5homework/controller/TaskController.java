package com.example.Seminar5homework.controller;

import com.example.Seminar5homework.FactoryMethod.ExampleFabricMethod;
import com.example.Seminar5homework.model.Task;
import com.example.Seminar5homework.service.FileGateway;
import com.example.Seminar5homework.service.TaskService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
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


    private final FileGateway fileGateway;
    private final TaskService taskService;

    private final Counter requestCounter = Metrics.counter("request_count");

    @GetMapping()
    public List<Task> getAllTasks(){
        requestCounter.increment();
        return taskService.getAllTasks();
    }

//    @GetMapping()
//    public ResponseEntity<List<Task>> getAllTasks() {
//        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
//    }

    @PostMapping() public Task addTask(@RequestBody Task task){
        task.setDatetime(LocalDateTime.now());
        fileGateway.writeToFile(task.getDescription() + ".txt", task.toString());
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