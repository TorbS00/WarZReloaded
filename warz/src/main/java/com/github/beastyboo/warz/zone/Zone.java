package com.github.beastyboo.warz.zone;

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

    //public boolean addLootTable()

}
