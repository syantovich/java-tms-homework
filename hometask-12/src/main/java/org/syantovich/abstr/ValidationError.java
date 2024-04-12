package org.syantovich.abstr;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ValidationError extends Exception {
    public ValidationError (String message){
        super(message);
    }
}
