package com.example.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    // Simulated database
    private Map<Long, String> database = new HashMap<>();
    private long idCounter = 1;

    // Endpoint to get a greeting message
    @GetMapping
    public String getGreeting() {
        return "Hello, World!";
    }

    // Endpoint to get a specific greeting message by ID
    @GetMapping("/{id}")
    public String getGreetingById(@PathVariable Long id) {
        return database.getOrDefault(id, "Greeting not found");
    }

    // Endpoint to create a new greeting message
    @PostMapping
    public String createGreeting(@RequestBody String message) {
        long id = idCounter++;
        database.put(id, message);
        return "Greeting created with ID: " + id;
    }
}
