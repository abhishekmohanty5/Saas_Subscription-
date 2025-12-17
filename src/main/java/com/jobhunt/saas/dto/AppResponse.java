package com.jobhunt.saas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppResponse<T> {
    private String message;
    private T data;
    private int status;
    private LocalDateTime timestamp;
}
