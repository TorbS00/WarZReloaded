package com.github.beastyboo.warz.map;

import org.bukkit.World;

import java.util.Map;
import java.util.Objects;

public record WarZMap(String name, World referenceWorld,
                      Map<String, Town> towns) {

    public String getName() {
        return name;
    }

    public World getReferenceWorld() {
        return referenceWorld;
    }

    public Map<String, Town> getTowns() {
        return towns;
    }

    public void registerTown(Town town) {
        towns.put(town.getName().toLowerCase(), town);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarZMap warZMap = (WarZMap) o;
        return name.equals(warZMap.name) && referenceWorld.equals(warZMap.referenceWorld) && towns.equals(warZMap.towns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, referenceWorld, towns);
    }

    @Override
    public String toString() {
        return "WarZMap{" +
                "name='" + name + '\'' +
                ", referenceWorld=" + referenceWorld +
                ", towns=" + towns +
                '}';
    }
}
