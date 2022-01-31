package com.github.beastyboo.guns;

import com.github.beastyboo.guns.api.GunsAPI;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public class GunsDataPlugin extends JavaPlugin {

    private Guns core;

    @Override
    public void onEnable() {
        core = new Guns(this);
        core.load();
        getServer().getServicesManager().register(GunsAPI.class, core, this, ServicePriority.Low);
    }

    @Override
    public void onDisable() {
        core.close();
        core = null;
    }

}
