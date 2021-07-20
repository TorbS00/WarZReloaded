package com.github.beastyboo.consumable;

import com.github.beastyboo.consumable.api.ConsumableAPI;
import com.github.beastyboo.consumable.api.ConsumablePlugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ConsumableDataPlugin extends JavaPlugin implements ConsumablePlugin {

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

    @Override
    public ConsumableAPI getAPI() {
        return core;
    }
}
