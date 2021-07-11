package com.github.beastyboo.foundation.exception;

import com.mongodb.MongoException;

public class MongoExceptionHandler {

    public MongoExceptionHandler() {
    }

    public RuntimeException handle(MongoException ex) {
        throw new UncheckedMongoException("JDBC query execution error", ex);
    }
}
