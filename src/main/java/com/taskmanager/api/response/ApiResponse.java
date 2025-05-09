package com.taskmanager.api.response;

import lombok.*;


@AllArgsConstructor
@Getter
@Setter
public class ApiResponse<T> {

    private boolean success;
    private String message;
    private T data;

}
