package com.sample.mongo.springbootmongodbdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleEmployeeNotFoundException(EmployeeNotFoundException employeeNotFoundException){
        Error error = new Error(employeeNotFoundException.getMessage(),HttpStatus.NOT_FOUND.getReasonPhrase());
        return new ErrorResponse(Arrays.asList(error));
    }

    @ExceptionHandler(EmployeeAgeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleEmployeeAgeException(EmployeeAgeException employeeAgeException){
        Error error = new Error(employeeAgeException.getMessage(),HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ErrorResponse(Arrays.asList(error));
    }
}
