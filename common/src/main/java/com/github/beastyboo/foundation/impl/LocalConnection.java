package com.github.beastyboo.foundation.impl;

import com.github.beastyboo.foundation.LocalAccess;
import com.github.beastyboo.foundation.registry.CollectionData;

import java.io.File;

public class LocalConnection implements LocalAccess {

    private final File pluginDirectory;
    private final Runnable runnable;
    private final Enum<? extends CollectionData> collection;

    public LocalConnection(File pluginDirectory, Runnable runnable, Enum<? extends CollectionData> collection) {
        this.pluginDirectory = pluginDirectory;
        this.runnable = runnable;
        this.collection = collection;
    }

    @Override
    public File pluginDirectory() {
        return pluginDirectory;
    }

    @Override
    public Runnable runnable() {
        return runnable;
    }


    @Override
    public Enum<? extends CollectionData> collection() {
        return collection;
    }

}
