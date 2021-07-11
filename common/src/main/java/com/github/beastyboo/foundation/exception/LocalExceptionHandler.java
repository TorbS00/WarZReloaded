package com.github.beastyboo.foundation.exception;

import java.io.IOException;
import java.io.UncheckedIOException;

public class LocalExceptionHandler {

    public LocalExceptionHandler() {
    }

    public RuntimeException handle(IOException ex) {
        throw new UncheckedIOException("Local storage execution error", ex);
    }

}
