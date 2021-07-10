package com.github.beastyboo.foundation;

import com.github.beastyboo.foundation.core.CollectionData;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public interface MongoAccess {

    MongoClient client();

    MongoDatabase database();

    <E extends Enum<E> & CollectionData> E collection();
}
