package com.example.cdcdebezium.kafka;

import com.example.cdcdebezium.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.example.cdcdebezium.kafka.KafkaConfig.TOPIC_CDC_CUSTOMER;

@Log4j2
@Component
public class KafkaListener {

    private final ObjectMapper objectMapper;
    private final CustomerService customerService;

    public KafkaListener(ObjectMapper objectMapper, CustomerService customerService) {
        this.objectMapper = objectMapper;
        this.customerService = customerService;
    }

    @org.springframework.kafka.annotation.KafkaListener(topics = TOPIC_CDC_CUSTOMER)
    public void consume(@Payload String message) throws JsonProcessingException {
        KafkaPayload kafkaPayload = objectMapper.readValue(message, KafkaPayload.class);
        log.info(String.format("receiving test_consumer1: %s ", message));
        customerService.replicateData(kafkaPayload.getData(), kafkaPayload.getOperation());
    }

}
