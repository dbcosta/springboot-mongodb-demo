package com.sample.mongo.springbootmongodbdemo.dto;

import com.sample.mongo.springbootmongodbdemo.enums.BaseLocation;
import com.sample.mongo.springbootmongodbdemo.enums.Gender;
import com.sample.mongo.springbootmongodbdemo.enums.Role;
import com.sample.mongo.springbootmongodbdemo.enums.Seniority;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class EmployeeDto {
    private long id;
    @NotBlank
    private String name;
    private int age;
    private Gender gender;
    private LocalDate dateOfJoining;
    private BigDecimal salary;
    private BaseLocation baseLocation;
    private Role role;
    private Seniority seniority;
}
