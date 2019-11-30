package com.nordryd.nmow.init;

import static com.nordryd.nmow.block.types.BranchPartType.LEAF;
import static com.nordryd.nmow.block.types.BranchPartType.SEED;
import static com.nordryd.nmow.block.types.BranchPartType.STEM;
import static com.nordryd.nmow.block.variant.VariantFactory.getBranchBlock;
import static com.nordryd.nmow.init.ModItems.TEST_ITEM;
import static com.nordryd.nmow.util.Randomizer.coinToss;
import static com.nordryd.nmow.util.values.Dimensions.OVERWORLD;
import static com.nordryd.nmow.util.values.HarvestLevel.DIAMOND;
import static com.nordryd.nmow.util.values.ToolType.PICKAXE;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.nordryd.nmow.block.ModBlock;
import com.nordryd.nmow.block.ModOre;
import com.nordryd.nmow.block.properties.BlockProperties;
import com.nordryd.nmow.block.properties.OreProperties;
import com.nordryd.nmow.block.variant.Branches;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface ModBlocks {
    List<Block> MOD_BLOCKS = new ArrayList<>();
    List<ModOre> MOD_ORES = new ArrayList<>();

    Block TEST_BLOCK = new ModBlock(
            new BlockProperties("test_block").material(Material.SNOW).soundType(SoundType.SNOW).hardness(5.0f)
                                             .resistance(15.0f).toolTypeRequired(PICKAXE).toolMaterialRequired(DIAMOND));

    Block TEST_ORE = new ModOre(
            new OreProperties().dimensionId(OVERWORLD).minHeight(5).maxHeight(200).minVeinSize(5).maxVeinSize(10)
                               .spawnChance(33),
            new BlockProperties("test_ore").toolMaterialRequired(DIAMOND).toolTypeRequired(PICKAXE).lightLevel(10)
                                           .soundType(SoundType.STONE).material(Material.ROCK)) {
        @Override
        public Item getItemDropped(final IBlockState state, final Random rand, final int fortune) {
            return TEST_ITEM;
        }

        @Override
        public int quantityDropped(final Random rng) {
            return rng.nextInt(10) + 1;
        }
    };

    Block BRANCHES = new Branches(new BlockProperties("branches").soundType(SoundType.PLANT).material(Material.PLANTS)) {
        @Override
        public void onBlockAdded(final World world, final BlockPos pos, final IBlockState state) {
            if ((state.getValue(BRANCH_SEGMENTS) == SEED) && coinToss()) {
                world.setBlockState(pos.up(), getBranchBlock(STEM));
                world.setBlockState(pos.up(2), getBranchBlock(LEAF));
                world.setBlockState(pos.up().east(), getBranchBlock(LEAF));
                world.setBlockState(pos.up().west(), getBranchBlock(LEAF));
                world.setBlockState(pos.up().north(), getBranchBlock(LEAF));
                world.setBlockState(pos.up().south(), getBranchBlock(LEAF));
            }
        }
    };
}
