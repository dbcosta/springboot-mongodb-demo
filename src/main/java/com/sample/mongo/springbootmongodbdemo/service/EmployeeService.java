package com.sample.mongo.springbootmongodbdemo.service;

import com.sample.mongo.springbootmongodbdemo.dto.EmployeeDto;
import com.sample.mongo.springbootmongodbdemo.exception.EmployeeAgeException;
import com.sample.mongo.springbootmongodbdemo.exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();
    EmployeeDto addEmployee(EmployeeDto employeeToBeAdded);
    EmployeeDto getEmployeeById(long id) throws EmployeeNotFoundException;
    EmployeeDto updateEmployee(long id, EmployeeDto employeeToBeUpdated) throws EmployeeNotFoundException,
            EmployeeAgeException;

    void deleteEmployee(long id);
}
