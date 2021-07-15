package com.github.beastyboo.teams;

import com.github.beastyboo.teams.api.TeamsAPI;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Teams implements TeamsAPI {

    private final JavaPlugin plugin;
    private final Logger logger;

    Teams(JavaPlugin plugin) {
        this.plugin = plugin;
        this.logger = plugin.getLogger();
    }

    void load() {
        logger.info("Starting WarZ-Teams");
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
