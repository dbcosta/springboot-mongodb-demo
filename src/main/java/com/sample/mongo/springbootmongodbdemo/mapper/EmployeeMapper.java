package com.sample.mongo.springbootmongodbdemo.mapper;

import com.sample.mongo.springbootmongodbdemo.domain.Employee;
import com.sample.mongo.springbootmongodbdemo.dto.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "id",source = "id")
    EmployeeDto employeeToEmployeeDTO(Employee employee);

    Employee employeeDtoToEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> employeesToEmployeesDTO(List<Employee> employees);
}
