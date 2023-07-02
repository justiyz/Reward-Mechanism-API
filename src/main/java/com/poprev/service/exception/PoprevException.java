package com.poprev.service.exception;

public class PoprevException extends Exception {
    public PoprevException() {
        super();
    }

    public PoprevException(String message) {
        super(message);
    }

    public PoprevException(String message, Throwable cause) {
        super(message, cause);
    }

    public PoprevException(Throwable cause) {
        super(cause);
    }

    protected PoprevException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
