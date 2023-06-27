package com.sample.mongo.springbootmongodbdemo.mapper;

import com.sample.mongo.springbootmongodbdemo.domain.Employee;
import com.sample.mongo.springbootmongodbdemo.dto.EmployeeDto;
import com.sample.mongo.springbootmongodbdemo.enums.BaseLocation;
import com.sample.mongo.springbootmongodbdemo.enums.Gender;
import com.sample.mongo.springbootmongodbdemo.enums.Role;
import com.sample.mongo.springbootmongodbdemo.enums.Seniority;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "id",source = "id")
    @Mapping(target = "baseLocation", source = "baseLocation",qualifiedByName = "stringToBaseLocation")
    @Mapping(target = "role", source = "role",qualifiedByName = "stringToRole")
    @Mapping(target = "seniority", source = "seniority",qualifiedByName = "stringToSeniority")
    @Mapping(target = "gender", source = "gender",qualifiedByName = "stringToGender")
    EmployeeDto employeeToEmployeeDTO(Employee employee);

    @Mapping(target = "baseLocation", source = "baseLocation",qualifiedByName = "baseLocationToString")
    @Mapping(target = "role", source = "role",qualifiedByName = "roleToString")
    @Mapping(target = "seniority", source = "seniority",qualifiedByName = "seniorityToString")
    @Mapping(target = "gender", source = "gender",qualifiedByName = "genderToString")
    Employee employeeDtoToEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> employeesToEmployeesDTO(List<Employee> employees);

    @Named("stringToBaseLocation")
    public static BaseLocation stringToBaseLocation(String baseLocation){
        return BaseLocation.fromValue(baseLocation);
    }

    @Named("stringToRole")
    public static Role stringToRole(String role){
        return Role.fromValue(role);
    }

    @Named("stringToSeniority")
    public static Seniority stringToSeniority(String seniority){
        return Seniority.fromValue(seniority);
    }

    @Named("stringToGender")
    public static Gender stringToGender(String gender){
        return Gender.fromValue(gender);
    }

    @Named("baseLocationToString")
    public static String baseLocationToString(BaseLocation baseLocation){
        return baseLocation.getName();
    }

    @Named("roleToString")
    public static String roleToString(Role role){
        return role.getName();
    }

    @Named("seniorityToString")
    public static String seniorityToString(Seniority seniority){
        return seniority.getName();
    }

    @Named("genderToString")
    public static String genderToString(Gender gender){
        return gender.getName();
    }
}
