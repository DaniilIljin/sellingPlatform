package com.example.backend.exception;

import org.springframework.security.core.parameters.P;

public class UsernameAlreadyExistsException extends RuntimeException{

    public UsernameAlreadyExistsException(String message) {
        super(message);
    }
}
