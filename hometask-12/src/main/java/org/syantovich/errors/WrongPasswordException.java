package org.syantovich.errors;

import lombok.NoArgsConstructor;
import org.syantovich.abstr.ValidationError;

@NoArgsConstructor
public class WrongPasswordException extends ValidationError {
    public WrongPasswordException(String message) {
        super(message);
    }
}
