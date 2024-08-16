package com.example.backend;

import java.io.IOException;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ShutdownHook {

    @EventListener(ContextClosedEvent.class)
    public void onApplicationShutdown(ContextClosedEvent event) {
        try {
            System.out.println("Application is shutting down. Running 'docker-compose down -v'...");
            ProcessBuilder processBuilder = new ProcessBuilder("docker-compose", "down", "-v");
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            process.waitFor();
            System.out.println("Docker containers are removed.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.err.println("Failed to deletedocker containers.");
        }
    }
}
