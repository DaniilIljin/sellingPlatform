package com.example.backend.advice;

import com.example.backend.dto.ErrorDetails;
import com.example.backend.exception.ItemNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorDetails> exceptionItemNotFoundHandler(ItemNotFoundException e) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setId(e.getId());
        errorDetails.setName(e.getName());
        errorDetails.setMessage(e.getMessage());
        return ResponseEntity.
                badRequest().
                body(errorDetails);
    }
}
