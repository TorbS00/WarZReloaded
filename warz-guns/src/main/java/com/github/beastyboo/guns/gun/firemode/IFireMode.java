package com.github.beastyboo.guns.gun.firemode;

import com.github.beastyboo.guns.Guns;
import com.github.beastyboo.guns.gun.Gun;
import org.bukkit.entity.Player;

public interface IFireMode {

    /**
     * Gets the String identity of a certain FireMode.
     * Used for IO purposes
     *
     * @return identity
     */
    String identifier();

    /**
     * Execute a gunshot from the players perspective.
     *
     * @param core plugin core
     * @param player targeted player
     * @param gun selected gun
     * @return true if gun was executed properly
     */
    boolean executeGunShot(Guns core, Player player, Gun gun);


}
