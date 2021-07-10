package com.github.beastyboo.warz;

import org.bukkit.plugin.java.JavaPlugin;

public class WarZPlugin extends JavaPlugin {

    private WarZ core;

    @Override
    public void onEnable() {
        core = new WarZ(this);
        core.load();
    }

    @Override
    public void onDisable() {
        core.close();
        core = null;
    }

}
