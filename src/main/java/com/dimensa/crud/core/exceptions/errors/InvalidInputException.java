package com.dimensa.crud.core.exceptions.errors;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super("Invalid input: " + message);
    }
}