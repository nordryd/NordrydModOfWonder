package com.nordryd.nmow.world;

import static com.nordryd.nmow.init.ModBlocks.test_ore;

import com.nordryd.nmow.config.OreGenConfig;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGenerator {
    public static void setup() {
        if (OreGenConfig.generate_overworld.get()) {
            ForgeRegistries.BIOMES.forEach(biome -> biome.addFeature(Decoration.UNDERGROUND_ORES,
                    Biome.createDecoratedFeature(Feature.ORE,
                            new OreFeatureConfig(FillerBlockType.NATURAL_STONE, test_ore.getDefaultState(), 17),
                            Placement.COUNT_RANGE, new CountRangeConfig(OreGenConfig.test_ore_chance.get(), 20, 20, 255))));
        }
        //        Biomes.BADLANDS.addFeature(Decoration.SURFACE_STRUCTURES, Feature.STRUCTURES.forcePut(Structure<?> object here));
    }
}
