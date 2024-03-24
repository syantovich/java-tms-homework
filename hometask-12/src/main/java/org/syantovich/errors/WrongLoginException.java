package org.syantovich.errors;

import lombok.NoArgsConstructor;
import org.syantovich.abstr.ValidationError;

@NoArgsConstructor
public class WrongLoginException extends ValidationError {
    public WrongLoginException (String message) {
        super(message);
    }
}
