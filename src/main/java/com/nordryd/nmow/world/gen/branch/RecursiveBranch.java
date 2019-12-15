package com.nordryd.nmow.world.gen.branch;

import static com.nordryd.nmow.block.types.BranchPartType.LEAF;
import static com.nordryd.nmow.block.types.BranchPartType.STEM;
import static com.nordryd.nmow.block.variant.VariantFactory.getBranchBlock;
import static java.lang.Math.max;
import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static net.minecraft.init.Blocks.AIR;
import static net.minecraft.init.Blocks.FLOWING_WATER;
import static net.minecraft.init.Blocks.WATER;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * A branch structure that recursively generates from a placed seed block.
 */
public class RecursiveBranch {

    private static final Random RNG = new Random();
    private static final List<Block> CAN_CUT_THRU = asList(AIR, WATER, FLOWING_WATER);
    private static final int MIN_ITERATIONS = 5, MAX_ITERATIONS = 25;

    private final World world;
    private final int iterations;
    private final double branchFactor;

    private BlockPos pos;
    private int currentIteration;

    /**
     * Constructor for {@link RecursiveBranch}.
     *
     * @param world the world instance.
     * @param initialPos the {@link BlockPos position} of the placed seed block.
     * @param branchFactor the probability that another branch will spawn from the current one.
     */
    public RecursiveBranch(final World world, final BlockPos initialPos, final double branchFactor) {
        this.world = world;
        this.iterations = RNG.nextInt(MAX_ITERATIONS - MIN_ITERATIONS) + MIN_ITERATIONS;
        this.pos = initialPos;
        this.currentIteration = 0;
        this.branchFactor = max(branchFactor, 0.0);
        generate();
    }

    private void generate() {
        final Direction nextDirection = getNextBranchDirection(pos);
        if (nextDirection != null) {
            pos = nextDirection.getNextBlockPos(pos);
            if (RNG.nextDouble() < branchFactor) {
                new RecursiveBranch(world, pos, branchFactor / 2.0);
            }

            if (++currentIteration > iterations) {
                world.setBlockState(pos, getBranchBlock(LEAF));
            }
            else {
                world.setBlockState(pos, getBranchBlock(STEM));
                generate();
            }
        }
    }

    @Nullable
    private Direction getNextBranchDirection(final BlockPos pos) {
        final List<Direction> possibleDirections = stream(Direction.values())
                .filter(direction -> CAN_CUT_THRU.contains(world.getBlockState(direction.getNextBlockPos(pos)).getBlock()))
                .collect(toList());
        return possibleDirections.isEmpty() ? null : possibleDirections.get(RNG.nextInt(possibleDirections.size()));
    }

    private enum Direction {
        UP(BlockPos::up),
        DOWN(BlockPos::down),
        NORTH(BlockPos::north),
        SOUTH(BlockPos::south),
        EAST(BlockPos::east),
        WEST(BlockPos::west);

        final Function<BlockPos, BlockPos> blockPosTranslator;

        Direction(final Function<BlockPos, BlockPos> blockPosTranslator) {
            this.blockPosTranslator = blockPosTranslator;
        }

        final BlockPos getNextBlockPos(final BlockPos pos) {
            return blockPosTranslator.apply(pos);
        }
    }
}

