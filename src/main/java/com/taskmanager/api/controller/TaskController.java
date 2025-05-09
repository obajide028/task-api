package com.taskmanager.api.controller;

import com.taskmanager.api.dto.TaskRequestDTO;
import com.taskmanager.api.entity.Task;
import com.taskmanager.api.response.ApiResponse;
import com.taskmanager.api.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Task>>> getAllTasks(){
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(new ApiResponse<>(true, "Tasks retrieved", tasks));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Task>> getTaskById(@PathVariable Long id){
       Task task = taskService.getTaskById(id);
       return ResponseEntity.ok(new ApiResponse<>(true, "Task retrieved", task));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<Task>> createTask(@Valid @RequestBody TaskRequestDTO taskRequest){
       Task task = taskService.createTask(taskRequest);

       return ResponseEntity.status(HttpStatus.CREATED)
               .body(new ApiResponse<>(true, "Task Created", task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Task>> updateTask(@PathVariable Long id, @RequestBody TaskRequestDTO taskRequestDTO) {
            Task updatedTask = taskService.updateTask(id, taskRequestDTO);
            return ResponseEntity.ok(new ApiResponse<>(true, "Task Updated successfully", updatedTask));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Task deleted successfully", null));
    }
}
