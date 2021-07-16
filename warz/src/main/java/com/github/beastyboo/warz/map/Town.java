package com.github.beastyboo.warz.map;

import com.github.beastyboo.warz.map.zone.Zone;

import java.util.Objects;

public record Town(String name, Zone zone,
                   TownBorder border) {

    public String getName() {
        return name;
    }

    public Zone getZone() {
        return zone;
    }

    public TownBorder getBorder() {
        return border;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Town town = (Town) o;
        return name.equals(town.name) && zone.equals(town.zone) && border.equals(town.border);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, zone, border);
    }

    @Override
    public String toString() {
        return "Town{" +
                "name='" + name + '\'' +
                ", zone=" + zone +
                ", border=" + border +
                '}';
    }
}
