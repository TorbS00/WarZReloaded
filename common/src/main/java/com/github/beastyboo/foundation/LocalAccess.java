package com.github.beastyboo.foundation;

import com.github.beastyboo.foundation.registry.AccessData;
import com.github.beastyboo.foundation.registry.CollectionData;

import java.io.File;

public interface LocalAccess extends AccessData {

    File pluginDirectory();

    Runnable runnable();

    Enum<? extends CollectionData> collection();

}
