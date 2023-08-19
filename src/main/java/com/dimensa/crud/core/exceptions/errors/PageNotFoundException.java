package com.dimensa.crud.core.exceptions.errors;

public class PageNotFoundException extends RuntimeException {
    public PageNotFoundException(int pageNumber) {
        super("Page number " + pageNumber + " not found");
    }
}
