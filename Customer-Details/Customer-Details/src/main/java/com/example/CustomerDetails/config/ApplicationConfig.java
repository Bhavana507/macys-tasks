package com.example.CustomerDetails.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ObjectMapper build(){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;
    }
 }
