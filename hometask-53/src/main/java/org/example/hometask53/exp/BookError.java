package org.example.hometask53.exp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookError extends Exception {
    private String message;
}
