package com.example.student.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceException {
    public static class StudentNotfoundException extends RuntimeException {

    }
    @ExceptionHandler(value = StudentNotfoundException.class)
    public ResponseEntity<Object> exception(StudentNotfoundException exception) {
        return new ResponseEntity<>("student not found", HttpStatus.NOT_FOUND);
    }
}
