package com.nordryd.nmow.block.properties;

import static com.nordryd.nmow.util.values.Dimensions.OVERWORLD;

public class OreProperties {
    private int dimensionId = OVERWORLD, spawnChance = 20, minVeinSize = 1, maxVeinSize = 6, minHeight = 1, maxHeight = 255;

    public int dimensionId() {
        return dimensionId;
    }

    public OreProperties dimensionId(final int dimensionId) {
        this.dimensionId = dimensionId;
        return this;
    }

    public int spawnChance() {
        return spawnChance;
    }

    public OreProperties spawnChance(final int spawnChance) {
        this.spawnChance = spawnChance;
        return this;
    }

    public int minVeinSize() {
        return minVeinSize;
    }

    public OreProperties minVeinSize(final int minVeinSize) {
        this.minVeinSize = minVeinSize;
        return this;
    }

    public int maxVeinSize() {
        return maxVeinSize;
    }

    public OreProperties maxVeinSize(final int maxVeinSize) {
        this.maxVeinSize = maxVeinSize;
        return this;
    }

    public int minHeight() {
        return minHeight;
    }

    public OreProperties minHeight(final int minHeight) {
        this.minHeight = minHeight;
        return this;
    }

    public int maxHeight() {
        return maxHeight;
    }

    public OreProperties maxHeight(final int maxHeight) {
        this.maxHeight = maxHeight;
        return this;
    }
}
