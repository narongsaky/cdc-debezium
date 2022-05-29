package com.example.cdcdebezium.kafka;

import lombok.Data;

import java.util.Map;

@Data
public class KafkaPayload {

    private String operation;

    private Map<String, Object> data;

}
