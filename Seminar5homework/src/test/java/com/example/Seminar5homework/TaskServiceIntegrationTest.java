package com.example.Seminar5homework;

import com.example.Seminar5homework.model.Task;
import com.example.Seminar5homework.model.TaskStatus;
import com.example.Seminar5homework.repository.TaskRepository;
import com.example.Seminar5homework.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
@SpringBootTest
public class TaskServiceIntegrationTest {

    @Autowired
    TaskService taskService;
    @MockBean
    TaskRepository taskRepository;

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
