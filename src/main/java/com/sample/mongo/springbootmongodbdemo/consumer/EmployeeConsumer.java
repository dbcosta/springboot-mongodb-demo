package com.sample.mongo.springbootmongodbdemo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeConsumer {

    @KafkaListener(topics = "add_employee",groupId = "employeeGroup")
    public void consumeMessage(String message){
        log.info("Message received - Newly added employee with details: "+message);
    }
}
