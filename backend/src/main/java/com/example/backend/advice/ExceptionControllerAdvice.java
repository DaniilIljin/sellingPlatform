package com.example.backend.advice;

import com.example.backend.dto.ErrorDetails;
import com.example.backend.exception.UsernameAlreadyExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDetails> exceptionEntityNotFoundHandler(EntityNotFoundException e) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(e.getMessage());
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }

    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ResponseEntity<ErrorDetails> exceptionUsernameAlreadyExistsHandler(UsernameAlreadyExistsException e) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage(e.getMessage());
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}
