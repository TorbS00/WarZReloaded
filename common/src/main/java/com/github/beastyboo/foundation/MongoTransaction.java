package com.github.beastyboo.foundation;

public class MongoTransaction implements Transaction, AutoCloseable {

    @Override
    public <T> T getType(Class<T> typeClass) {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
