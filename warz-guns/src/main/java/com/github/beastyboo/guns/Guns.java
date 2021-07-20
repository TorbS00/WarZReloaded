package com.github.beastyboo.guns;

import com.github.beastyboo.guns.api.GunsAPI;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Guns implements GunsAPI {

    private final JavaPlugin plugin;
    private final Logger logger;

    Guns(JavaPlugin plugin) {
        this.plugin = plugin;
        this.logger = plugin.getLogger();
    }

    void load() {
        logger.info("Starting WarZ-Guns");
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
