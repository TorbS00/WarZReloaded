package com.github.beastyboo.foundation;

import com.github.beastyboo.foundation.core.AccessData;
import com.github.beastyboo.foundation.core.CollectionData;

import java.io.File;

public interface LocalAccess extends AccessData {

    File pluginDirectory();

    <E extends Enum<E> & CollectionData> E collection();

}
