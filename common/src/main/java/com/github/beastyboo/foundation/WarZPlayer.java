package com.github.beastyboo.foundation;

import java.util.Optional;
import java.util.UUID;

public interface WarZPlayer {

    /**
     * Gets the player UUID created by mojang.
     *
     * @return mojang UUID
     */
    UUID getUUID();

    /**
     * Check if the player is online.
     *
     * @return online status
     */
    boolean online();

    /**
     * Converts the WarZPlayer to an OnlineWarZPlayer
     *
     * @return OnlineWarZPlayer if online, else return empty
     */
    Optional<OnlineWarZPlayer> playerToOnlineConverter();

}
