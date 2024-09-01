package org.example.hometask53.advice;

import org.example.hometask53.exp.BookError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandles {
    @ExceptionHandler(BookError.class)
    public ResponseEntity<BookError> handleBookError(BookError bookError) {
        return ResponseEntity.badRequest().body(bookError);
    }
}
