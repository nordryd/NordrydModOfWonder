package com.nordryd.nmow.block.builders;

public class OreProperties {
    private int dimensionId, spawnChance, minVeinSize, maxVeinSize, minHeight, maxHeight;

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
