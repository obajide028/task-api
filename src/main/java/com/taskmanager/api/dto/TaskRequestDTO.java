package com.taskmanager.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequestDTO {

    @NotBlank(message = "Title is required")
    private String Title;

    private String description;

    private boolean completed;
}
