package com.github.beastyboo.foundation.registry;

public interface EntityManager extends AutoCloseable{

    @Override
    default void close() throws Exception {}

}
