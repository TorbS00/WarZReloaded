package com.github.beastyboo.warz;

import com.github.beastyboo.foundation.LocalAccess;
import com.github.beastyboo.foundation.registry.CollectionData;

import java.io.File;

public class LocalConnection implements LocalAccess {

    private final File pluginDirectory;
    private final Collections collection;

    public LocalConnection(File pluginDirectory, Collections collection) {
        this.pluginDirectory = pluginDirectory;
        this.collection = collection;
    }

    @Override
    public File pluginDirectory() {
        return pluginDirectory;
    }

    @Override
    public <E extends Enum<E> & CollectionData> E collection() {
        return (E) collection;
    }
}
