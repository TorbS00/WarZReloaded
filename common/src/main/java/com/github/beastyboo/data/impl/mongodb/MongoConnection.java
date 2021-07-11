package com.github.beastyboo.data.impl.mongodb;

import com.github.beastyboo.data.CollectionData;
import com.github.beastyboo.data.Connection;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoConnection implements Connection {

    private final MongoClient client;

    public MongoConnection(MongoClient client) {
        this.client = client;
    }

    public MongoClient getClient() {
        return client;
    }

    public MongoTransaction transactionFactory(String databaseName, Enum<? extends CollectionData> collection) {
        return new MongoTransaction() {
            @Override
            public MongoClient getClient() {
                return client;
            }
            @Override
            public MongoDatabase getDatabase() {
                return client.getDatabase(databaseName);
            }
            @Override
            public Enum<? extends CollectionData> getCollection() {
                return collection;
            }
        };
    }
}
