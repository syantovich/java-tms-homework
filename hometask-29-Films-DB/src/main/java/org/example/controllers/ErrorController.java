package org.example.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "/error";
    }
}
