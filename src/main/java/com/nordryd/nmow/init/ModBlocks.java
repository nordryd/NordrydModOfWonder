package com.nordryd.nmow.init;

import static com.nordryd.nmow.init.ModItemGroups.MASTER;
import static com.nordryd.nmow.util.enums.HarvestLevel.DIAMOND;
import static net.minecraft.block.SoundType.LANTERN;
import static net.minecraft.block.SoundType.SNOW;
import static net.minecraft.block.material.Material.ROCK;
import static net.minecraft.block.material.Material.SAND;
import static net.minecraftforge.common.ToolType.PICKAXE;

import java.util.ArrayList;
import java.util.List;

import com.nordryd.nmow.blocks.ModBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public interface ModBlocks {
    List<Block> MOD_BLOCKS = new ArrayList<>();

    Block test_block = new ModBlock("test_block",
            Block.Properties.create(SAND).hardnessAndResistance(5f, 15f).lightValue(10).sound(SNOW)
                            .harvestLevel(DIAMOND.getLevel()).harvestTool(PICKAXE), new Item.Properties().group(MASTER));
    Block test_ore = new ModBlock("test_ore", new Item.Properties().group(MASTER),
            Block.Properties.create(ROCK).hardnessAndResistance(5f, 15f).lightValue(4).sound(LANTERN)
                            .harvestLevel(DIAMOND.getLevel()).harvestTool(PICKAXE));
}
