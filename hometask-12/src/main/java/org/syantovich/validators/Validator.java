package org.syantovich.validators;

import org.syantovich.abstr.ValidationError;

import java.util.regex.Pattern;

public class Validator {
    String value;
    boolean result = false;
    ValidationError exception;

    public Validator(String value, ValidationError exception) {
        this.value = value;
        this.exception = exception;
    }

    public Validator(String value) {
        this(value, new ValidationError(String.format("Failed to validate %s", value)));
    }

    private void setResult(boolean nextResult) throws ValidationError {
        if (!nextResult) {
            throw exception;
        }
    }


    Validator maxLength(int length) throws ValidationError {
        setResult(this.value.length() < length);
        return this;
    }

    Validator withoutSpace() throws ValidationError {
        setResult(!value.contains(" "));
        return this;
    }

    Validator containNumber() throws ValidationError {
        Pattern pattern = Pattern.compile(".*\\d.*");
        setResult(Pattern.compile(".*\\d.*").matcher(this.value).find());
        return this;
    }

    Validator equalAnotherValue(String anotherValue) throws ValidationError {
        setResult(this.value.equals(anotherValue));
        return this;
    }
}
