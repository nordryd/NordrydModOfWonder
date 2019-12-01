package com.nordryd.nmow.world.gen;

import static com.nordryd.nmow.init.ModBlocks.MOD_ORES;
import static com.nordryd.nmow.util.values.Dimensions.END;
import static com.nordryd.nmow.util.values.Dimensions.NETHER;
import static com.nordryd.nmow.util.values.Dimensions.OVERWORLD;
import static com.nordryd.nmow.util.values.Values.CHUNK_SIZE;
import static java.lang.String.format;
import static java.util.stream.IntStream.range;
import static net.minecraft.block.state.pattern.BlockMatcher.forBlock;

import java.util.Random;

import com.nordryd.nmow.block.ModOre;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGenerator implements IWorldGenerator {

    @Override
    public void generate(final Random rng, final int chunkX, final int chunkZ, final World world,
            final IChunkGenerator chunkGenerator, final IChunkProvider chunkProvider) {
        MOD_ORES.stream().forEach(
                ore -> generateOre(ore, world, rng, chunkX, chunkZ, forBlock(getDimensionBaseBlock(ore.getDimensionId()))));
    }

    private void generateOre(final ModOre ore, final World world, final Random rng, final int chunkX, final int chunkZ,
            final BlockMatcher generateIn) {
        final int veinSize = rng.nextInt(ore.getMaxVeinSize() - ore.getMinVeinSize()) + ore.getMinHeight();
        final int heightRange = ore.getMaxHeight() - ore.getMinHeight();

        final WorldGenMinable worldGenMinable = new WorldGenMinable(ore.getDefaultState(), veinSize, generateIn);

        range(0, ore.getSpawnChance()).forEach(chance -> worldGenMinable.generate(world, rng,
                new BlockPos((chunkX * CHUNK_SIZE) + rng.nextInt(CHUNK_SIZE), rng.nextInt(heightRange) + ore.getMinHeight(),
                        (chunkZ * CHUNK_SIZE) + rng.nextInt(CHUNK_SIZE))));
    }

    private Block getDimensionBaseBlock(final int dimensionId) {
        switch (dimensionId) {
            case OVERWORLD:
                return Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE).getBlock();
            case NETHER:
                return Blocks.NETHERRACK;
            case END:
                return Blocks.END_STONE;
            default:
                throw new IllegalArgumentException(format("Dimension %d does not exist!", dimensionId));
        }
    }
}
