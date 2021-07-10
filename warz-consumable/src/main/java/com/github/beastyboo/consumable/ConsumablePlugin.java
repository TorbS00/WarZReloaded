package com.github.beastyboo.consumable;

import org.bukkit.plugin.java.JavaPlugin;

public class ConsumablePlugin extends JavaPlugin {

    private Consumable core;

    @Override
    public void onEnable() {
        core = new Consumable(this);
        core.load();
    }

    @Override
    public void onDisable() {
        core.close();
        core = null;
    }

}
