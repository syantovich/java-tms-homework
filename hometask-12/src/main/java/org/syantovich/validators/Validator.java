package org.syantovich.validators;

import org.syantovich.abstr.ValidationError;

import java.util.regex.Pattern;

public class Validator {

    static void validateMaxLength(String value, int length) throws ValidationError {
        if (value.length() > length) {
            throw new ValidationError();
        }
    }

    static void withoutSpace(String value) throws ValidationError {
        if (value.contains(" ")) {
            throw new ValidationError();
        }
    }

    static void containNumber(String value) throws ValidationError {
        Pattern pattern = Pattern.compile(".*\\d.*");
        if (!pattern.matcher(value).find()) {
            throw new ValidationError();
        }
    }

    static void equalAnotherValue(String value, String anotherValue) throws ValidationError {
        if (!value.equals(anotherValue)) {
            throw new ValidationError();
        }
    }
}
