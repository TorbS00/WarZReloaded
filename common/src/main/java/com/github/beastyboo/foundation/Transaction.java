package com.github.beastyboo.foundation;

public interface Transaction {

    /**
     * Get a certain type from the current transaction
     *
     * @param typeClass the class representing the type
     * @param <T> the type
     * @return type
     */
    <T> T getType(Class<T> typeClass);

}
