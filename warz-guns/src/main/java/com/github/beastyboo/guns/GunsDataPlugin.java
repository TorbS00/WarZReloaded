package com.github.beastyboo.guns;

import com.github.beastyboo.guns.api.GunsAPI;
import com.github.beastyboo.guns.api.GunsPlugin;
import org.bukkit.plugin.java.JavaPlugin;

public class GunsDataPlugin extends JavaPlugin implements GunsPlugin {

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

    @Override
    public GunsAPI getAPI() {
        return core;
    }
}
