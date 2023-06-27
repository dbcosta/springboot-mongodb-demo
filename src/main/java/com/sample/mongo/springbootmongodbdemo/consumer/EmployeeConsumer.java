package com.sample.mongo.springbootmongodbdemo.consumer;

import com.sample.mongo.springbootmongodbdemo.domain.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeConsumer {

    @KafkaListener(topics = "add_employee",groupId = "employeeGroup")
    public void consumeMessage(Employee employee){
        log.info("Message received - Newly added employee with details: "+employee);
    }
}
