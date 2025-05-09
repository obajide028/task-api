package com.taskmanager.api.service;

import com.taskmanager.api.dto.TaskRequestDTO;
import com.taskmanager.api.entity.Task;
import java.util.List;


public interface TaskService {

    public Task createTask(TaskRequestDTO requestDTO);

    public List<Task> getAllTasks();

    public Task getTaskById(Long id);

    public Task updateTask(Long id, TaskRequestDTO requestDTO);

    public void deleteTask(Long id);
}