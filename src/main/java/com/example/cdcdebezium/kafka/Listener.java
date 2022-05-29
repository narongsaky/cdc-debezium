package com.example.cdcdebezium.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.example.cdcdebezium.kafka.KafkaConfig.TOPIC_CDC_CUSTOMER;

@Log4j2
@Component
public class Listener {

    private final ObjectMapper objectMapper;

    public Listener(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = TOPIC_CDC_CUSTOMER)
    public void consume(@Payload String message) throws JsonProcessingException {
        KafkaPayload kafkaPayload = objectMapper.readValue(message, KafkaPayload.class);
        log.info(String.format("receiving test_consumer1: %s ", message));
    }

}
