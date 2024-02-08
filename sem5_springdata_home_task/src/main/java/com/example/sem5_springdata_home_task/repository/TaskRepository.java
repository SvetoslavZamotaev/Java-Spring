package com.example.sem5_springdata_home_task.repository;

import com.example.sem5_springdata_home_task.domain.Task;
import com.example.sem5_springdata_home_task.domain.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
}
