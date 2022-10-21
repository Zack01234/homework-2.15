package com.example.homework2_15.exeptions;

public class ListFromSizeException extends RuntimeException {
    public ListFromSizeException() {
    }

    public ListFromSizeException(String message) {
        super(message);
    }

    public ListFromSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ListFromSizeException(Throwable cause) {
        super(cause);
    }

    public ListFromSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
