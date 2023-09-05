package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class DemoController {

    @GetMapping
    public Map<String, String> regioes() {
        return Map.of("estado", "Paraná", "cidade", "Curitiba");
    }
}
