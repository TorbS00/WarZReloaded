package com.github.beastyboo.consumable;

import com.github.beastyboo.consumable.api.ConsumableAPI;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Consumable implements ConsumableAPI {

    private final JavaPlugin plugin;
    private final Logger logger;

    Consumable(JavaPlugin plugin) {
        this.plugin = plugin;
        this.logger = plugin.getLogger();
    }

    void load() {
        logger.info("Starting WarZ-Consumable");
    }

    void close() {

    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    public Logger getLogger() {
        return logger;
    }

}
