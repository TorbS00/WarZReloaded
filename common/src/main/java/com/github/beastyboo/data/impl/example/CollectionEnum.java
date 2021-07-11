package com.github.beastyboo.data.impl.example;

import com.github.beastyboo.data.CollectionData;

public enum CollectionEnum implements CollectionData {

    CLAN;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
