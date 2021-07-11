package com.github.beastyboo.foundation.impl;

import com.github.beastyboo.foundation.MongoAccess;
import com.github.beastyboo.foundation.registry.CollectionData;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.TransactionBody;

public class MongoConnection implements MongoAccess {

    private final ClientSession session;
    private final MongoDatabase database;
    private final TransactionBody transactionBody;
    private final Enum<? extends CollectionData> collection;

    public MongoConnection(ClientSession session, MongoDatabase database, TransactionBody transactionBody, Enum<? extends CollectionData> collection) {
        this.session = session;
        this.database = database;
        this.transactionBody = transactionBody;
        this.collection = collection;
    }

    @Override
    public ClientSession session() {
        return session;
    }

    @Override
    public MongoDatabase database() {
        return database;
    }

    @Override
    public Enum<? extends CollectionData> collection() {
        return collection;
    }

}
