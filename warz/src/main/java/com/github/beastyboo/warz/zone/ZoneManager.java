package com.github.beastyboo.warz.zone;

import com.github.beastyboo.foundation.Transaction;
import com.github.beastyboo.foundation.registry.EntityManager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ZoneManager implements EntityManager {

    //Cached Zone objects should stay alive (Unless we modify them), therefore Java's Map abstract data type is sufficient.
    private final Map<Integer, Zone> zones = new ConcurrentHashMap<>();

    /**
     *
     * @param transaction transaction the transaction
     * @param id id id of desired clan
     * @throws NullPointerException if zone not found.
     * @return zone if found.
     */
    public Zone getZone(Transaction transaction, int id) {



        return zones.get(id);
    }

    /**
     * Retrieve an immutable cached zone object. (May not be accurate)
     *
     * @param id id of zone
     * @throws NullPointerException if id is not in cache.
     * @return Zone
     */
    public Zone getCachedZone(int id) {
        return zones.get(id);
    }

    /**
     * Creates a zone (Zone Factory), and add it to current cache + storage.
     *
     * @param transaction the transaction
     * @param id id of desired clan
     * @return created zone
     */
    public Zone createZone(Transaction transaction, int id) {
        if(getCachedZone(id) != null) {
            return null;
        }

        return new Zone(id);
    }

    /**
     * Deletes a zone from the cache and offline storage.
     *
     * @param transaction the transaction
     * @param zone the desired zone to be destructed.
     */
    public void deleteZone(Transaction transaction, Zone zone) {

    }

}
