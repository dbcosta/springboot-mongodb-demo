package com.sample.mongo.springbootmongodbdemo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Document(collection = "employees")
public class Employee {

    @Transient
    public static final String SEQUENCE_NAME = "employees_sequence";

    @Id
    private long id;
    private String name;
    private int age;
    private String gender;
    private LocalDate dateOfJoining;
    private BigDecimal salary;
    private String baseLocation;
    private String role;
    private String seniority;
}
