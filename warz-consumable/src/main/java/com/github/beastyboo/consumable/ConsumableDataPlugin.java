package com.github.beastyboo.consumable;

import com.github.beastyboo.consumable.api.ConsumableAPI;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

public class ConsumableDataPlugin extends JavaPlugin {

    private Consumable core;

    @Override
    public void onEnable() {
        core = new Consumable(this);
        core.load();
        getServer().getServicesManager().register(ConsumableAPI.class, core, this, ServicePriority.Low);
    }

    @Override
    public void onDisable() {
        core.close();
        core = null;
    }
}
