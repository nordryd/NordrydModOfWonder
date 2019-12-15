package com.nordryd.nmow.world.biomes;

import static com.nordryd.nmow.init.ModBiomes.MOD_BIOMES;
import static net.minecraftforge.common.BiomeDictionary.addTypes;
import static net.minecraftforge.common.BiomeManager.BiomeEntry;
import static net.minecraftforge.common.BiomeManager.addBiome;
import static net.minecraftforge.common.BiomeManager.addSpawnBiome;
import static net.minecraftforge.fml.common.registry.ForgeRegistries.BIOMES;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class ModBiome extends Biome {

    private final BiomeType biomeType;
    private final Type[] types;

    public ModBiome(final BiomeProperties biomeProperties, final BiomeType biomeType, final Type... types) {
        super(biomeProperties);
        this.biomeType = biomeType;
        this.types = types;
        MOD_BIOMES.add(this);
    }

    public final void registerModBiome() {
        setRegistryName(getBiomeName());
        BIOMES.register(this);
        addTypes(this, types);
        addBiome(biomeType, new BiomeEntry(this, 10));
        addSpawnBiome(this);
    }
}
