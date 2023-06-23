package com.sample.mongo.springbootmongodbdemo.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class EmployeeDto {
    private long id;
    private String name;
    private int age;
    private LocalDate dateOfJoining;
    private BigDecimal salary;
    private String baseLocation;
    private String role;
    private String seniority;
}
