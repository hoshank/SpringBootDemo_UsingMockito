package com.bl.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(UserExceptions.class)
    public ResponseEntity<String> LoginRegisterExceptionHandler(UserExceptions e) {
        return new ResponseEntity<>(e.message, HttpStatus.BAD_REQUEST);

    }
}