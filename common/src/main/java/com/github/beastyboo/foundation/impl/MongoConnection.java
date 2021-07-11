package com.github.beastyboo.foundation.impl;

import com.github.beastyboo.foundation.MongoAccess;
import com.github.beastyboo.foundation.registry.CollectionData;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoConnection implements MongoAccess {

    private final MongoClient client;
    private final MongoDatabase database;
    private final Enum<? extends CollectionData> collection;

    public MongoConnection(MongoClient client, MongoDatabase database, Enum<? extends CollectionData> collection) {
        this.client = client;
        this.database = database;
        this.collection = collection;
    }

    @Override
    public MongoClient client() {
        return client;
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
