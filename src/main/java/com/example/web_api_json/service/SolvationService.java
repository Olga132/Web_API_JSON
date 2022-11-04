package com.example.web_api_json.service;

import com.example.web_api_json.logic.ISolvator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


// контроллер
@Controller                                // REST-контроллер
@RequestMapping("/service")             // маршрутизация
public class SolvationService {

    @Autowired                      // автосвязывание
    private ISolvator solvator;     // объект интерфейс решателя (DI)

    // 1. ping
    @GetMapping("/ping")
    public @ResponseBody ClassMessages.Message ping() {
        return new ClassMessages.Message("pong");
    }

    // 2. статус сервера
    @GetMapping("/status")
    public @ResponseBody ClassMessages.Message status() {
        return new ClassMessages.Message("Server status OK at port 8080");
    }

    // 3. решение
    @PostMapping("/solve")
    public @ResponseBody ClassMessages.IMessage solve(@RequestBody ClassMessages.InputMessage input) {
        return solvator.solve(input);
    }

}
