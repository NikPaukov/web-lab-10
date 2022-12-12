package com.example.lab10.exceptionHandling;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorResponseBody {
    private String message;
    private String route;
}
