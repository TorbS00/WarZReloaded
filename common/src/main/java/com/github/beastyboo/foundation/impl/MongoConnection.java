package com.github.beastyboo.foundation.impl;

import com.github.beastyboo.foundation.MongoAccess;
import com.github.beastyboo.foundation.registry.CollectionData;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.TransactionBody;

public class MongoConnection implements MongoAccess {

    private final MongoClient client;
    private final MongoDatabase database;
    private final TransactionBody transactionBody;
    private final Enum<? extends CollectionData> collection;

    public MongoConnection(MongoClient client, MongoDatabase database, TransactionBody transactionBody, Enum<? extends CollectionData> collection) {
        this.client = client;
        this.database = database;
        this.transactionBody = transactionBody;
        this.collection = collection;
    }

    @Override
    public MongoClient getClient() {
        return client;
    }

    @Override
    public MongoDatabase getDatabase() {
        return database;
    }

    @Override
    public TransactionBody getTransactionBody() {
        return transactionBody;
    }

    @Override
    public Enum<? extends CollectionData> getCollection() {
        return collection;
    }

}
