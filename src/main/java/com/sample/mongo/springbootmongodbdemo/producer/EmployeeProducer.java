package com.sample.mongo.springbootmongodbdemo.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sample.mongo.springbootmongodbdemo.domain.Employee;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class EmployeeProducer {

    private KafkaTemplate<String,Employee> kafkaTemplate;

    public void sendMessage(Employee employee) throws JsonProcessingException {
        log.info("Adding a new employee with id: "+employee.getId());
        Message<Employee> employeeMessage = MessageBuilder.withPayload(employee).setHeader(KafkaHeaders.TOPIC,"add_employee")
                                                                  .build();
        kafkaTemplate.send(employeeMessage);
        log.info("New employee added with details: "+employeeMessage.getPayload());
    }
}
