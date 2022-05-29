package com.example.cdcdebezium;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CdcDebeziumApplication {

	public static void main(String[] args) {
		SpringApplication.run(CdcDebeziumApplication.class, args);
	}

	@Bean("objectMapper")
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

}
