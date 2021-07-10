package com.github.beastyboo.foundation;

import com.github.beastyboo.foundation.core.CollectionData;

import java.io.File;

public interface LocalAccess {

    File pluginDirectory();

    <E extends Enum<E> & CollectionData> E collection();

}
