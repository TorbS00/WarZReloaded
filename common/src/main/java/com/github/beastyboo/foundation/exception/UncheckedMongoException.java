package com.github.beastyboo.foundation.exception;

public class UncheckedMongoException extends RuntimeException {

    public UncheckedMongoException(String message) {
        super(message);
    }

    public UncheckedMongoException(String message, Throwable cause) {
        super(message, cause);
    }

    public UncheckedMongoException(Throwable cause) {
        super(cause);
    }
}
