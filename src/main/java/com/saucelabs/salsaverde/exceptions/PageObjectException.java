package com.saucelabs.salsaverde.exceptions;

public class PageObjectException extends RuntimeException {
    public PageObjectException(String message) {
        super(message);
    }

    public PageObjectException(String message, Throwable cause) {
        super(message, cause);
    }
}
