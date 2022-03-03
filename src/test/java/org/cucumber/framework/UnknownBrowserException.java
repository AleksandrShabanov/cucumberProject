package org.cucumber.framework;

public class UnknownBrowserException extends RuntimeException {
    public UnknownBrowserException(String message) {
        super(message);
    }
}
