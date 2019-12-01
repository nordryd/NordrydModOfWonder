package com.nordryd.nmow.world.biomes;

import static com.nordryd.nmow.block.types.BranchPartType.LEAF;
import static com.nordryd.nmow.block.variant.Branches.BRANCH_SEGMENTS;
import static com.nordryd.nmow.init.ModBlocks.BRANCHES;
import static com.nordryd.nmow.init.ModBlocks.TEST_BLOCK;
import static com.nordryd.nmow.init.ModBlocks.TEST_ORE;
import static net.minecraftforge.common.BiomeDictionary.Type.COLD;
import static net.minecraftforge.common.BiomeManager.BiomeType.COOL;

import java.util.Random;

import com.nordryd.nmow.world.gen.trees.TestTree;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class TestBiome extends ModBiome {
    public TestBiome(final String name) {
        super(new BiomeProperties(name).setBaseHeight(0.1f).setHeightVariation(0.2f).setTemperature(0.2f)
                                       .setWaterColor(16711935), COOL, COLD);
        topBlock = TEST_BLOCK.getDefaultState();
        fillerBlock = topBlock;

        decorator.coalGen = new WorldGenMinable(TEST_ORE.getDefaultState(), 10);
        decorator.andesiteGen = new WorldGenMinable(BRANCHES.getDefaultState().withProperty(BRANCH_SEGMENTS, LEAF), 10);
        decorator.treesPerChunk = 0;
        decorator.extraTreeChance = 0.05f;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(final Random rng) {
        return new TestTree();
    }
}
