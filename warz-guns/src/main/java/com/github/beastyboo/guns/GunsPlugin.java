package com.github.beastyboo.guns;

import org.bukkit.plugin.java.JavaPlugin;

public class GunsPlugin extends JavaPlugin {

    private Guns core;

    @Override
    public void onEnable() {
        core = new Guns(this);
        core.load();
    }

    @Override
    public void onDisable() {
        core.close();
        core = null;
    }

}
