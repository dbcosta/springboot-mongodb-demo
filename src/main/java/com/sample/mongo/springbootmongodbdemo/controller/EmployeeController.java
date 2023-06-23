package com.sample.mongo.springbootmongodbdemo.controller;

import com.sample.mongo.springbootmongodbdemo.dto.EmployeeDto;
import com.sample.mongo.springbootmongodbdemo.exception.EmployeeAgeException;
import com.sample.mongo.springbootmongodbdemo.exception.EmployeeNotFoundException;
import com.sample.mongo.springbootmongodbdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeToBeAdded){
        return new ResponseEntity<>(employeeService.addEmployee(employeeToBeAdded),HttpStatus.CREATED);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable long id) throws EmployeeNotFoundException {
        return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable long id,@RequestBody EmployeeDto employeeToBeUpdated) throws
            EmployeeNotFoundException, EmployeeAgeException {
        return new ResponseEntity<>(employeeService.updateEmployee(id, employeeToBeUpdated),HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

}
