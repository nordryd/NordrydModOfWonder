package com.nordryd.nmow.world;

import static com.nordryd.nmow.init.ModBlocks.test_ore;

import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGenerator {
    public static void setup() {
        ForgeRegistries.BIOMES.forEach(biome -> biome.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE
                .func_225566_b_(new OreFeatureConfig(FillerBlockType.NATURAL_STONE, test_ore.getDefaultState(), 17))
                .func_227228_a_(Placement.COUNT_RANGE.func_227446_a_(new CountRangeConfig(50, 20, 20, 255)))));

        //        Biomes.BADLANDS.addFeature(Decoration.SURFACE_STRUCTURES, Feature.STRUCTURES.forcePut(Structure<?> object here));
    }
}
