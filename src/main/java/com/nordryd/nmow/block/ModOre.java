package com.nordryd.nmow.block;

import static com.nordryd.nmow.init.ModBlocks.MOD_ORES;

import java.util.Random;

import com.nordryd.nmow.block.properties.BlockProperties;
import com.nordryd.nmow.block.properties.OreProperties;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class ModOre extends ModBlock {

    private final int dimensionId, spawnChance, minVeinSize, maxVeinSize, minHeight, maxHeight;

    public ModOre(final BlockProperties blockProperties, final OreProperties oreProperties) {
        super(blockProperties);

        this.dimensionId = oreProperties.dimensionId();
        this.spawnChance = oreProperties.spawnChance();
        this.minVeinSize = oreProperties.minVeinSize();
        this.maxVeinSize = oreProperties.maxVeinSize();
        this.minHeight = oreProperties.minHeight();
        this.maxHeight = oreProperties.maxHeight();

        MOD_ORES.add(this);
    }

    public ModOre(final OreProperties oreProperties, final BlockProperties blockProperties) {
        this(blockProperties, oreProperties);
    }

    public int getDimensionId() {
        return dimensionId;
    }

    public int getSpawnChance() {
        return spawnChance;
    }

    public int getMinVeinSize() {
        return minVeinSize;
    }

    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }
}
