package com.github.beastyboo.foundation;

import com.github.beastyboo.foundation.registry.AccessData;
import com.github.beastyboo.foundation.registry.CollectionData;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoDatabase;

public interface MongoAccess extends AccessData {

    ClientSession session();

    MongoDatabase database();

    Enum<? extends CollectionData> collection();
}
