package com.nordryd.nmow.world.gen.trees;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class TestTree extends WorldGenAbstractTree {
    public TestTree() {
        super(false);
    }

    @Override
    public boolean generate(final World world, final Random rng, final BlockPos pos) {
        return false;
    }
}
