package com.nordryd.nmow.init;

import static com.nordryd.nmow.util.values.HarvestLevel.DIAMOND;
import static com.nordryd.nmow.util.values.ToolType.PICKAXE;

import java.util.ArrayList;
import java.util.List;

import com.nordryd.nmow.block.ModBlock;
import com.nordryd.nmow.block.ModOre;
import com.nordryd.nmow.block.properties.BlockProperties;
import com.nordryd.nmow.block.properties.OreProperties;
import com.nordryd.nmow.util.values.Dimensions;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface ModBlocks {
    List<Block> MOD_BLOCKS = new ArrayList<>();

    Block TEST_BLOCK = new ModBlock(
            new BlockProperties("test_block").material(Material.SNOW).soundType(SoundType.SNOW).hardness(5.0f)
                                             .resistance(15.0f).toolTypeRequired(PICKAXE).toolMaterialRequired(DIAMOND)) {
        @Override
        public void onBlockAdded(final World world, final BlockPos pos, final IBlockState blockState) {
            System.out.printf("%s added to the world!", blockState.getBlock().getLocalizedName());
            super.onBlockAdded(world, pos, blockState);
        }
    };

    Block TEST_ORE = new ModOre(
            new OreProperties().dimensionId(Dimensions.OVERWORLD).minHeight(5).maxHeight(200).minVeinSize(5).maxVeinSize(10)
                               .spawnChance(33),
            new BlockProperties("test_ore").toolMaterialRequired(DIAMOND).toolTypeRequired(PICKAXE).lightLevel(10)
                                           .soundType(SoundType.STONE).material(Material.ROCK)) {
        @Override
        public void onEntityCollidedWithBlock(final World world, final BlockPos pos, final IBlockState blockState,
                final Entity entity) {
            System.out.printf("%s touched by %s", blockState.getBlock().getLocalizedName(), entity.getName());
            super.onEntityCollidedWithBlock(world, pos, blockState, entity);
        }
    };

    //Block SEED_BLOCK, Block STEM_BLOCK, Block LEAF_BLOCK; <--- variants!!! recursive gen test blocks
}
