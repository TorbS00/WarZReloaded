package com.github.beastyboo.warz;

import com.github.beastyboo.foundation.MongoAccess;
import com.github.beastyboo.foundation.registry.CollectionData;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoConnection implements MongoAccess {

    private final MongoClient client;
    private final MongoDatabase database;
    private final Collections collection;

    public MongoConnection(MongoClient client, MongoDatabase database, Collections collection) {
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
    public <E extends Enum<E> & CollectionData> E collection() {
        return (E) collection;
    }

}
