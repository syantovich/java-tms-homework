package org.syantovich.validators;

import org.syantovich.abstr.ValidationError;
import org.syantovich.errors.WrongConfirmPasswordException;
import org.syantovich.errors.WrongLoginException;
import org.syantovich.errors.WrongPasswordException;

public class Registration {

    public static void validate(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException, WrongConfirmPasswordException {
        Registration.validateLogin(login);
        Registration.validatePassword(password);
        Registration.validateConfirmPassword(password, confirmPassword);
    }

    public static void validateLogin(String value) throws WrongLoginException {
        try {
            Validator.maxLength(value, 22);
            Validator.withoutSpace(value);
        } catch (ValidationError error) {
            System.out.println("WrongLoginException");
            throw new WrongLoginException(error.getMessage());
        }
    }

    public static void validatePassword(String value) throws WrongPasswordException {
        try {
            Validator.maxLength(value, 20);
            Validator.containNumber(value);
            Validator.withoutSpace(value);
        } catch (ValidationError error) {
            System.out.println("WrongPasswordException");
            throw new WrongPasswordException(error.getMessage());
        }
    }

    public static void validateConfirmPassword(String password, String confirmPassword) throws WrongConfirmPasswordException {
        try {
            Validator.equalAnotherValue(password, confirmPassword);
        } catch (ValidationError error) {
            System.out.println("WrongConfirmPasswordException");
            throw new WrongConfirmPasswordException(error.getMessage());
        }
    }

    public static void main(String[] args) {
       try{
           Registration.validateLogin("Somelogin");
           Registration.validatePassword("adssdd2");
           Registration.validateConfirmPassword("adssdd2", "21321");
           Registration.validate("dsadas", "adssdd2", "adssdd2");
       }catch (ValidationError err){

       }
    }
}
