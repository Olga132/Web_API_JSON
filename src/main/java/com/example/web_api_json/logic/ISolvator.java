package com.example.web_api_json.logic;

import com.example.web_api_json.service.ClassMessages;
import org.springframework.stereotype.Component;

// интерфейс решателя уравнений
@Component
public interface ISolvator {
    // метод решения
    ClassMessages.OutputMessage solve(ClassMessages.InputMessage input);
}