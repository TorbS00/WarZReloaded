package com.github.beastyboo.foundation.core;

public interface EntityManager extends AutoCloseable{

    @Override
    default void close() throws Exception {}

}
