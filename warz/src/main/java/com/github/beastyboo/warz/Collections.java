package com.github.beastyboo.warz;

import com.github.beastyboo.foundation.registry.CollectionData;

public enum Collections implements CollectionData {

    ZONE;

    @Override
    public String toString() {
        return ZONE.name().toLowerCase();
    }
}
