package com.example.sem5_springdata_home_task.controller;

import com.example.sem5_springdata_home_task.domain.Task;
import com.example.sem5_springdata_home_task.domain.TaskStatus;
import com.example.sem5_springdata_home_task.service.TaskService;
import java.util.List;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/tasks")
public class TaskController {


    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskService.getTasksByStatus(status);
    }

    @PutMapping("/{taskId}/status/{status}")
    public Task updateTaskStatus(@PathVariable Long taskId, @PathVariable TaskStatus status) {
        return taskService.updateTaskStatus(taskId, status);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }

//    @PutMapping("/{id}")
//    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task) {
//        return taskService.updateStatus(id, task.getStatus());
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteTask(@PathVariable Long id) {
//        taskService.delete(id);
//    }

    //@PutMapping("/{id}")
    //public ResponseEntity<Task> updateTaskStatus(@PathVariable Long id, @RequestParam TaskStatus status) {
    //    Optional<Task> optionalTask = taskRepository.findById(id);
    //    if (optionalTask.isPresent()) {
    //        Task task = optionalTask.get();
    //        task.setStatus(status);
    //        taskRepository.save(task);
    //        return ResponseEntity.ok(task);
     //   } else {
    //        return ResponseEntity.notFound().build();
    //    }
    //}

    //@DeleteMapping("/{id}")
    //public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
    //    Optional<Task> optionalTask = taskRepository.findById(id);
    //    if (optionalTask.isPresent()) {
    //        taskRepository.deleteById(id);
    //        return ResponseEntity.noContent().build();
    //    } else {
    //        return ResponseEntity.notFound().build();
    //    }
    //}

}
