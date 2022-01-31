package com.github.beastyboo.warz;

import com.github.beastyboo.warz.api.WarZAPI;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public class WarZDataPlugin extends JavaPlugin {

    private WarZ core;

    @Override
    public void onEnable() {
        core = new WarZ(this);
        core.load();
        getServer().getServicesManager().register(WarZAPI.class, core, this, ServicePriority.Low);
    }

    @Override
    public void onDisable() {
        core.close();
        core = null;
    }
}
