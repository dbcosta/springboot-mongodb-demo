package com.sample.mongo.springbootmongodbdemo.service.impl;

import com.sample.mongo.springbootmongodbdemo.domain.Employee;
import com.sample.mongo.springbootmongodbdemo.dto.EmployeeDto;
import com.sample.mongo.springbootmongodbdemo.exception.EmployeeAgeException;
import com.sample.mongo.springbootmongodbdemo.exception.EmployeeNotFoundException;
import com.sample.mongo.springbootmongodbdemo.mapper.EmployeeMapper;
import com.sample.mongo.springbootmongodbdemo.repository.EmployeeRepository;
import com.sample.mongo.springbootmongodbdemo.service.EmployeeService;
import com.sample.mongo.springbootmongodbdemo.service.SequenceGeneratorService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employeeListFromDb = employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return employeeMapper.employeesToEmployeesDTO(employeeListFromDb);
    }

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeToBeAdded) {
        Employee employee = employeeMapper.employeeDtoToEmployee(employeeToBeAdded);
        employee.setId(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.employeeToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(long id) throws EmployeeNotFoundException {
        Employee employeeFromDb =
                employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found!"));
        return employeeMapper.employeeToEmployeeDTO(employeeFromDb);
    }

    @Override
    public EmployeeDto updateEmployee(long id, EmployeeDto employeeDtoToBeUpdated) throws EmployeeNotFoundException,
            EmployeeAgeException {
        Employee employeeById = employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee not found!"));
        Employee employeeToBeUpdated = employeeMapper.employeeDtoToEmployee(employeeDtoToBeUpdated);
        if(StringUtils.isNotBlank(employeeToBeUpdated.getName())){
            employeeById.setName(employeeToBeUpdated.getName());
        }
        if(employeeToBeUpdated.getAge()>20){
            employeeById.setAge(employeeToBeUpdated.getAge());
        }else{
            throw new EmployeeAgeException("Employee is under 21 years of age.");
        }
        if(employeeToBeUpdated.getSalary()!=null){
            employeeById.setSalary(employeeDtoToBeUpdated.getSalary());
        }
        if(StringUtils.isNotBlank(employeeToBeUpdated.getRole())){
            employeeById.setRole(employeeDtoToBeUpdated.getRole());
        }
        if(StringUtils.isNotBlank(employeeToBeUpdated.getSeniority())){
            employeeById.setSeniority(employeeDtoToBeUpdated.getSeniority());
        }
        if(employeeToBeUpdated.getDateOfJoining()!=null){
            employeeById.setDateOfJoining(employeeDtoToBeUpdated.getDateOfJoining());
        }
        if(StringUtils.isNotBlank(employeeToBeUpdated.getBaseLocation())){
            employeeById.setBaseLocation(employeeDtoToBeUpdated.getBaseLocation());
        }
        Employee savedEmployee = employeeRepository.save(employeeById);
        return employeeMapper.employeeToEmployeeDTO(savedEmployee);
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }
}
