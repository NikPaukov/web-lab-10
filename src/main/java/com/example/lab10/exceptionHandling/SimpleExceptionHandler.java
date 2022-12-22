package com.example.lab10.exceptionHandling;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.stream.Collectors;

@ControllerAdvice()
public class SimpleExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> validation(ConstraintViolationException ex, WebRequest request) {
        return new ResponseEntity<>(
                new ConstraintViolationsResponse(
                        ex.getConstraintViolations().stream()
                                .map(constraintViolation -> constraintViolation.getMessage())
                                .collect(Collectors.toList()),
                        request.toString().split(" ")[1].split(";")[0].substring(4)), new HttpHeaders(), HttpStatus.BAD_REQUEST);

    }
}
