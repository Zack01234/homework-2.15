package com.example.homework2_15.exeptions;

public class RequestNullException extends RuntimeException {
    public RequestNullException() {
    }

    public RequestNullException(String message) {
        super(message);
    }

    public RequestNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestNullException(Throwable cause) {
        super(cause);
    }

    public RequestNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
