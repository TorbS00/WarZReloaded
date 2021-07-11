package com.github.beastyboo.warz.zone;

import com.github.beastyboo.foundation.Transaction;

import java.util.HashSet;
import java.util.Set;

public class Zone {

    private final int zoneId;
    private final Set<LootTableItem> zoneLootTable;

    Zone(int zoneId, Set<LootTableItem> zoneLootTable) {
        this.zoneId = zoneId;
        this.zoneLootTable = zoneLootTable;
    }

    Zone(int zoneId) {
        this(zoneId, new HashSet<>());
    }

    /**
     * Gets the zone ID
     *
     * @return zoneId
     */
    public int getZoneId() {
        return zoneId;
    }

    /**
     * Gets all current LootTableItems in the Zone. Not accurate.
     * @return all LootTableItems, unmodifiable
     */
    public Set<LootTableItem> getZoneLootTable() {
        return Set.copyOf(zoneLootTable);
    }

    public boolean addLootTableItem(Transaction transaction, LootTableItem lootTableItem) {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zone zone = (Zone) o;
        return zoneId == zone.zoneId;
    }

    @Override
    public int hashCode() {
        return zoneId;
    }

    /*
    TODO: Override .toString when fields complete.
     */
}
