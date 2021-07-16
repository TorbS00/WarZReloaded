package com.github.beastyboo.warz.map;

import com.sk89q.worldedit.math.BlockVector3;

import java.util.Objects;

public record TownBorder(BlockVector3 borderPointA,
                         BlockVector3 borderPointB) {

    public BlockVector3 getBorderPointA() {
        return borderPointA;
    }

    public BlockVector3 getBorderPointB() {
        return borderPointB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TownBorder that = (TownBorder) o;
        return borderPointA.equals(that.borderPointA) && borderPointB.equals(that.borderPointB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(borderPointA, borderPointB);
    }

    @Override
    public String toString() {
        return "TownBorder{" +
                "borderPointA=" + borderPointA +
                ", borderPointB=" + borderPointB +
                '}';
    }
}
