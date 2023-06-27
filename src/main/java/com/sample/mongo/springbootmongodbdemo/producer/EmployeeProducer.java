package com.sample.mongo.springbootmongodbdemo.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sample.mongo.springbootmongodbdemo.domain.Employee;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class EmployeeProducer {

    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(Employee employee) throws JsonProcessingException {
        log.info("Adding a new employee with id: "+employee.getId());
        String employeeString = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(employee);
        kafkaTemplate.send("add_employee",employeeString);
        log.info("New employee added with details: "+employeeString);
    }
}
