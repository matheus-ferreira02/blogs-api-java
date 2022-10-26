package com.blogsapijava.enums;

import lombok.Getter;

@Getter
public enum ValidationsMessages {
    REQUIRED("Field is required and cannot be empty");

    private final String message;

    ValidationsMessages(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
