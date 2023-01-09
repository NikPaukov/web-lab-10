package com.example.pjwebback.exceptionHandling;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorResponseBody {
    private String message;
    private String route;
}
