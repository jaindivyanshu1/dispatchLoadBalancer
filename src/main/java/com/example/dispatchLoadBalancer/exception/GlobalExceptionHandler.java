package com.example.dispatchLoadBalancer.exception;

import com.example.dispatchLoadBalancer.controller.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(
                new ApiResponse("Validation error: " + ex.getMessage(), "fail"),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGeneric(Exception ex) {
        return new ResponseEntity<>(
                new ApiResponse("Error: " + ex.getMessage(), "fail"),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
