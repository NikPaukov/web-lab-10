package com.example.pjwebback.exceptionHandling;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ConstraintViolationsResponse {
    private List<String> message;
    private String route;
}
