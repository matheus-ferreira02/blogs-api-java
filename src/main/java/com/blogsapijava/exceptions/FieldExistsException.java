package com.blogsapijava.exceptions;

public class FieldExistsException extends RuntimeException {
    public FieldExistsException(String message) {
        super(message);
    }
}
