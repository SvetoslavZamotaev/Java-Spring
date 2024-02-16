package com.example.Seminar5homework;


import com.example.Seminar5homework.controller.TaskController;
import com.example.Seminar5homework.model.Task;
import com.example.Seminar5homework.model.TaskStatus;
import com.example.Seminar5homework.repository.TaskRepository;
import com.example.Seminar5homework.service.TaskService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)

public class TaskServiceUnitTest {
    @Mock
    public TaskRepository taskRepository;

    @InjectMocks
    public TaskController taskController;



    @InjectMocks
    public TaskService taskService;


    @Test
    void getAllTasksTest()  {
        //PRE
        LocalDateTime time = LocalDateTime.of(2024,12,23,17,34,23);

        Task task1 = new Task();
        task1.setId(1L);
        task1.setDescription("Starting test 1");
        task1.setStatus(TaskStatus.INPROCESS);
        task1.setDatetime(time);

        Task task2 = new Task();
        task2.setId(2L);
        task2.setDescription("Starting test 2");
        task2.setStatus(TaskStatus.INPROCESS);
        task2.setDatetime(time);

        List<Task> listTasks = List.of(task1,task2);

        given(taskRepository.findAll()).willReturn(listTasks);
            //ACTION
        taskService.getAllTasks();

        //CHECK
        verify(taskRepository).findAll();

    }



}
