package org.example;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FilmError extends Exception {
    private ErrorCodes errorCode;
}
