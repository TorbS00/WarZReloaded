package com.github.beastyboo.warz;

import com.github.beastyboo.warz.api.WarZAPI;
import com.github.beastyboo.warz.api.WarZPlugin;
import org.bukkit.plugin.java.JavaPlugin;

public class WarZDataPlugin extends JavaPlugin implements WarZPlugin {

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

    @Override
    public WarZAPI getAPI() {
        return core;
    }
}
