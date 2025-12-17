package com.jobhunt.saas.exception;

import com.jobhunt.saas.dto.AppResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidCredentialException.class)
    public ResponseEntity<AppResponse<String>> handleException(InvalidCredentialException ex) {
        AppResponse<String> response =
                new AppResponse<>("error",ex.getMessage(),401, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

}
