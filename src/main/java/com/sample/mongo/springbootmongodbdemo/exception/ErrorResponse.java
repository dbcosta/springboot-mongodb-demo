package com.sample.mongo.springbootmongodbdemo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private List<Error> errors;
}
