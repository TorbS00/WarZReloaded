package com.github.beastyboo.data.impl.mongodb;

import com.github.beastyboo.data.CollectionData;
import com.github.beastyboo.data.Transaction;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public interface MongoTransaction extends Transaction {

    MongoClient getClient();

    MongoDatabase getDatabase();

    Enum<? extends CollectionData> getCollection();

}
