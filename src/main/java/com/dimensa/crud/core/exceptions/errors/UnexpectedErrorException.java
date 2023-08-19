package com.dimensa.crud.core.exceptions.errors;

public class UnexpectedErrorException extends RuntimeException {
    public UnexpectedErrorException(String message) {
        super("Unexpected error occurred: " + message);
    }
}