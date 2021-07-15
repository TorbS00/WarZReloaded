package com.github.beastyboo.teams;

import org.bukkit.plugin.java.JavaPlugin;

public class TeamsPlugin extends JavaPlugin {

    private Teams core;

    @Override
    public void onEnable() {
        core = new Teams(this);
        core.load();
    }

    @Override
    public void onDisable() {
        core.close();
        core = null;
    }

}
