package com.github.beastyboo.foundation;

import com.github.beastyboo.foundation.core.CollectionData;

public interface MongoAccess {

    String ConnectionURI();

    String database();

    <E extends Enum<E> & CollectionData> E collection();
}
