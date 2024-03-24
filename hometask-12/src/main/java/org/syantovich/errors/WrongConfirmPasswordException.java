package org.syantovich.errors;

import lombok.NoArgsConstructor;
import org.syantovich.abstr.ValidationError;

@NoArgsConstructor
public class WrongConfirmPasswordException extends ValidationError {
    public WrongConfirmPasswordException(String message) {
        super(message);
    }
}
