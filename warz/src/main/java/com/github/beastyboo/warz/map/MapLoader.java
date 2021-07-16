package com.github.beastyboo.warz.map;

import com.grinderwolf.swm.api.SlimePlugin;
import com.grinderwolf.swm.api.exceptions.CorruptedWorldException;
import com.grinderwolf.swm.api.exceptions.NewerFormatException;
import com.grinderwolf.swm.api.exceptions.UnknownWorldException;
import com.grinderwolf.swm.api.exceptions.WorldInUseException;
import com.grinderwolf.swm.api.loaders.SlimeLoader;
import com.grinderwolf.swm.api.world.SlimeWorld;
import com.grinderwolf.swm.api.world.properties.SlimeProperties;
import com.grinderwolf.swm.api.world.properties.SlimePropertyMap;
import org.bukkit.Bukkit;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class MapLoader {

    //TODO: CLEANUP CREW INCOMING
    SlimePlugin plugin = (SlimePlugin) Bukkit.getPluginManager().getPlugin("SlimeWorldManager");
    SlimeLoader mongodbLoader = plugin.getLoader("mongodb");

    private SlimePropertyMap loadProperties() {
        SlimePropertyMap properties = new SlimePropertyMap();
        //TODO: Add in actual features
        properties.setValue(SlimeProperties.SPAWN_Y, 1);
        return properties;
    }

    Future<SlimeWorld> loadSlimeWorld() {
        return CompletableFuture.supplyAsync(() -> {
            SlimeWorld world = null;
            try {
                world = plugin.loadWorld(mongodbLoader, "WarZ-World", true, loadProperties());
            } catch (UnknownWorldException | IOException | CorruptedWorldException | NewerFormatException | WorldInUseException ex) {
                throw new RuntimeException("Could not load WarZ World from MongoDB properly!", ex);
            }

            plugin.generateWorld(world);
            return world;
        });
    }
}
