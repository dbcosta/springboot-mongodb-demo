package com.sample.mongo.springbootmongodbdemo.repository;

import com.sample.mongo.springbootmongodbdemo.domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,Long> {
}
