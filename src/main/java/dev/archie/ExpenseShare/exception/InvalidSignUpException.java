package dev.archie.ExpenseShare.exception;

public class InvalidSignUpException extends RuntimeException{
    public InvalidSignUpException(String message) {
        super(message);
    }
}
