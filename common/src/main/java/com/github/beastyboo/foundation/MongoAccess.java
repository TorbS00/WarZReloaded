package com.github.beastyboo.foundation;

import com.github.beastyboo.foundation.registry.AccessData;
import com.github.beastyboo.foundation.registry.CollectionData;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.TransactionBody;

public interface MongoAccess extends AccessData {

    MongoClient getClient();

    MongoDatabase getDatabase();

    TransactionBody getTransactionBody();

    Enum<? extends CollectionData> getCollection();
}
