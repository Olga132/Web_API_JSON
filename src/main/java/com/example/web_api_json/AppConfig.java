package com.example.web_api_json;

import com.example.web_api_json.logic.ISolvator;
import com.example.web_api_json.logic.SolvatorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// класс конфигурация для DI
@Configuration
public class AppConfig {
    // бин для решателя
    @Bean
    ISolvator solvator() {
        return new SolvatorImpl();
    }
}
