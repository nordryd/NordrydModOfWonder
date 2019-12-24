package com.nordryd.nmow.world;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.IcebergFeature;
import net.minecraft.world.gen.placement.IPlacementConfig;

public class DimensionalGenerator<F extends IFeatureConfig, P extends IPlacementConfig> extends Feature<F> {

    private final DimensionType dimension;

    public DimensionalGenerator(final Function<Dynamic<?>, ? extends F> configFactoryIn, final DimensionType dimension) {
        super(configFactoryIn);
        this.dimension = dimension;
    }

    @Override
    public boolean place(final IWorld worldIn, final ChunkGenerator<? extends GenerationSettings> generator,
            final Random rand, final BlockPos pos, final F config) {
        return false;
    }
}
