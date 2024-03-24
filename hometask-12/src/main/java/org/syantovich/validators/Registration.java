package org.syantovich.validators;

import org.syantovich.abstr.ValidationError;
import org.syantovich.errors.WrongConfirmPasswordException;
import org.syantovich.errors.WrongLoginException;
import org.syantovich.errors.WrongPasswordException;

public class Registration {

    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            Registration.validateLogin(login);
            Registration.validatePassword(password);
            Registration.validateConfirmPassword(password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException | WrongConfirmPasswordException error) {
            return false;
        }
    }

    private static void validateLogin(String value) throws WrongLoginException {
        try {
            Validator validator = new Validator(value, new WrongLoginException());
            validator.maxLength(20).withoutSpace();
        } catch (ValidationError error) {
            throw (WrongLoginException) error;
        }
    }

    private static void validatePassword(String value) throws WrongPasswordException {
        try {
            Validator validator = new Validator(value, new WrongPasswordException());
            validator.maxLength(20).containNumber().withoutSpace();
        } catch (ValidationError error) {
            throw (WrongPasswordException) error;
        }
    }

    private static void validateConfirmPassword(String password, String confirmPassword) throws WrongConfirmPasswordException {
        try {
            Validator validator = new Validator(password, new WrongConfirmPasswordException());
            validator.equalAnotherValue(confirmPassword);
        } catch (ValidationError error) {
            throw (WrongConfirmPasswordException) error;
        }
    }

    public static void main(String[] args) {
        System.out.println(Registration.validate("sdllls","adssdd2","21321"));
        System.out.println(Registration.validate("sdlllsdsfdsfdsfdsfdsfdsfdsfdsfdsfdsfdsfdsf","adssdd2","21321"));
        System.out.println(Registration.validate("dsadas","adssdd2","adssdd2"));

    }
}
