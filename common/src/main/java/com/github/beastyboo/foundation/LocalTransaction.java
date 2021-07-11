package com.github.beastyboo.foundation;

import com.github.beastyboo.foundation.exception.LocalExceptionHandler;
import com.github.beastyboo.foundation.impl.LocalConnection;

public class LocalTransaction implements Transaction{

    private final LocalConnection connection;

    LocalTransaction(LocalConnection connection) {
        this.connection = connection;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getType(Class<T> typeClass) {
        if(typeClass.equals(LocalConnection.class)) {
            return (T) connection;
        }
        if(typeClass.equals(LocalExceptionHandler.class)) {
            return (T) handler();
        }
        throw new IllegalArgumentException(
                "Transaction implementation LocalTransaction does not provide type of " + typeClass.getName());
    }

    private LocalExceptionHandler handler() {
        return new LocalExceptionHandler();
    }

}
