package com.github.beastyboo.warz;

import com.github.beastyboo.warz.api.WarZAPI;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class WarZ implements WarZAPI {

    private final JavaPlugin plugin;
    private final Logger logger;

    WarZ(JavaPlugin plugin) {
        this.plugin = plugin;
        this.logger = plugin.getLogger();
    }

    void load() {
        logger.info("Starting WarZ");
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
