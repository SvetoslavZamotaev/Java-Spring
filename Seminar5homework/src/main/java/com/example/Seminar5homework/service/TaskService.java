package com.example.Seminar5homework.service;

import com.example.Seminar5homework.model.Task;
import com.example.Seminar5homework.model.TaskStatus;
import com.example.Seminar5homework.repository.TaskRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class TaskService {


    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }


    public Optional<Task> getTaskById(Long id){
        return taskRepository.findById(id);
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

//    @PostConstruct
//    public void CreateStartingTasks() throws InterruptedException {
//        Task task1 = new Task();
//        task1.setId(1L);
//        task1.setDescription("Starting test 1");
//        task1.setStatus(TaskStatus.INPROCESS);
//        task1.setDatetime(LocalDateTime.now());
//
//        Task task2 = new Task();
//        task2.setId(2L);
//        task2.setDescription("Starting test 2");
//        task2.setStatus(TaskStatus.INPROCESS);
//        task2.setDatetime(LocalDateTime.now());
//
//        createTask(task1);
//        createTask(task2);
//    }

}
