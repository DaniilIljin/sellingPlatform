package com.example.backend.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class ItemNotFoundException extends RuntimeException{

    private final Long id;
    private final String name;

    public ItemNotFoundException(String message, Long id, String name) {
        super(message);
        this.id = id;
        this.name = name;
    }

}
