package com.efundzz.SpringBootCaching.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ExceptionResponse> EmployeeNotFound(EmployeeNotFoundException exception){

        ExceptionResponse exceptionResponse =new ExceptionResponse(
                LocalDateTime.now().toString(),
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage()
//                webRequest.getDescription(false)
        );

        return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);

    }
}
