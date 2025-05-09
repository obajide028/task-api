package com.taskmanager.api.service.implementation;

import com.taskmanager.api.dto.TaskRequestDTO;
import com.taskmanager.api.entity.Task;
import com.taskmanager.api.exceptions.ResourceNotFoundException;
import com.taskmanager.api.repository.TaskRepository;
import com.taskmanager.api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(TaskRequestDTO requestDTO) {
        Task task = new Task();
        task.setTitle(requestDTO.getTitle());
        task.setDescription(requestDTO.getDescription());

        return  taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
       return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Task not found with ID: " + id));
    }

    @Override
    public Task updateTask(Long id, TaskRequestDTO requestDTO) {
        Task task = getTaskById(id);
        task.setTitle(requestDTO.getTitle());
        task.setDescription(requestDTO.getDescription());
        task.setCompleted(requestDTO.isCompleted());
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
      Task task = getTaskById(id);
      taskRepository.delete(task);
    }
}
