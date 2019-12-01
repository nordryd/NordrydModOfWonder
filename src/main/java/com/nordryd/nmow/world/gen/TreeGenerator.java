package com.nordryd.nmow.world.gen;

import static com.nordryd.nmow.util.values.Dimensions.END;
import static com.nordryd.nmow.util.values.Dimensions.NETHER;
import static com.nordryd.nmow.util.values.Dimensions.OVERWORLD;
import static com.nordryd.nmow.util.values.Values.CHUNK_SIZE;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static net.minecraft.init.Biomes.FOREST;
import static net.minecraft.init.Biomes.PLAINS;
import static net.minecraft.init.Biomes.ROOFED_FOREST;
import static net.minecraft.init.Blocks.GRASS;

import java.util.List;
import java.util.Random;

import com.nordryd.nmow.world.gen.trees.TestTree;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class TreeGenerator implements IWorldGenerator {

    @Override
    public void generate(final Random rng, final int chunkX, final int chunkZ, final World world,
            final IChunkGenerator chunkGenerator, final IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case OVERWORLD:
                generateTree(new TestTree(), world, rng, chunkX, chunkZ, 1, GRASS, PLAINS, FOREST, ROOFED_FOREST);
                break;
            case NETHER:
            case END:
            default:
                break;
        }
    }

    private void generateTree(final WorldGenerator tree, final World world, final Random rng, final int chunkX,
            final int chunkZ, final int chance, final Block topBlock, final Biome... validBiomes) {
        final List<Class<?>> validBiomesClasses = stream(validBiomes).map(Object::getClass).collect(toList());

        final int x = (chunkX * CHUNK_SIZE) + rng.nextInt(CHUNK_SIZE - 1);
        final int z = (chunkZ * CHUNK_SIZE) + rng.nextInt(CHUNK_SIZE - 1);
        final int y = calculateGenerationHeight(world, x, z, topBlock);
        final BlockPos pos = new BlockPos(x, y, z);

        final Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
        if (validBiomesClasses.contains(biome) && (rng.nextInt() == 0)) {
            tree.generate(world, rng, pos);
        }
    }

    private int calculateGenerationHeight(final World world, final int x, final int z, final Block topBlock) {
        int y = world.getHeight();
        boolean foundGround = false;

        while (!foundGround && (y-- >= 0)) {
            foundGround = (topBlock == world.getBlockState(new BlockPos(x, y, z)).getBlock());
        }

        return y;
    }
}
