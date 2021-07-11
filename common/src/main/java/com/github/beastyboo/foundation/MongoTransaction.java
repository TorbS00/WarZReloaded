package com.github.beastyboo.foundation;

import com.github.beastyboo.foundation.exception.MongoExceptionHandler;
import com.github.beastyboo.foundation.impl.MongoConnection;

public class MongoTransaction implements Transaction, AutoCloseable {

    private final MongoConnection connection;

    MongoTransaction(MongoConnection connection) {
        this.connection = connection;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getType(Class<T> typeClass) {
        if(typeClass.equals(MongoConnection.class)) {
            return (T) connection;
        }
        if(typeClass.equals(MongoExceptionHandler.class)) {
            return (T) handler();
        }
        throw new IllegalArgumentException(
                "Transaction implementation MongoTransaction does not provide type of " + typeClass.getName());
    }

    @Override
    public void close() throws Exception {
        connection.session().close();
    }

    private MongoExceptionHandler handler() {
        return new MongoExceptionHandler();
    }
}
