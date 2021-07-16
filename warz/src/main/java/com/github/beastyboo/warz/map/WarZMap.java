package com.github.beastyboo.warz.map;

import org.bukkit.World;

import java.util.Map;

public final class WarZMap {

    private final String name;
    private final World world;
    private final Map<String, Town> towns;

    public WarZMap(String name, World world, Map<String, Town> towns) {
        this.name = name;
        this.world = world;
        this.towns = towns;
    }

    public String getName() {
        return name;
    }

    public World getWorld() {
        return world;
    }

    public Map<String, Town> getTowns() {
        return towns;
    }

    public void registerTown(Town town) {
        towns.put(town.getName().toLowerCase(), town);
    }

}
