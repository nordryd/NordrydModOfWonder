package com.nordryd.nmow.init;

import static com.nordryd.nmow.util.values.HarvestLevel.DIAMOND;
import static com.nordryd.nmow.util.values.ToolType.PICKAXE;

import java.util.ArrayList;
import java.util.List;

import com.nordryd.nmow.block.builders.BlockProperties;
import com.nordryd.nmow.block.ModBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface ModBlocks {
    List<Block> MOD_BLOCKS = new ArrayList<>();

    Block TEST_BLOCK = new ModBlock(
            new BlockProperties("test_block").material(Material.SNOW).soundType(SoundType.SNOW).hardness(5.0f)
                                             .resistance(15.0f).toolTypeRequired(PICKAXE).toolMaterialRequired(DIAMOND)) {
        @Override
        public void onBlockAdded(final World world, final BlockPos pos, final IBlockState blockState) {
            super.onBlockAdded(world, pos, blockState);
        }
    };
}
