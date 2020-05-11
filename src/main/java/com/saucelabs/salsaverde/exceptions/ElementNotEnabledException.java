package com.saucelabs.salsaverde.exceptions;

import org.openqa.selenium.InvalidElementStateException;

public class ElementNotEnabledException extends InvalidElementStateException {
    public ElementNotEnabledException(String message) {
        super(message);
    }

    public ElementNotEnabledException(String message, Throwable cause) {
        super(message, cause);
    }
}
