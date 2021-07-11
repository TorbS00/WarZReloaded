package com.github.beastyboo.foundation;

public class LocalTransaction implements Transaction, AutoCloseable {
    @Override
    public <T> T getType(Class<T> typeClass) {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
