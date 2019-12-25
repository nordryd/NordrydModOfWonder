package com.nordryd.nmow.blocks;

import static com.nordryd.nmow.util.ModUtility.getResourceLocation;
import static com.nordryd.nmow.init.ModBlocks.MOD_BLOCKS;
import static com.nordryd.nmow.init.ModItems.MOD_ITEMS;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class ModBlock extends Block {
    public ModBlock(final String registryName, final Properties blockProperties, final Item.Properties itemProperties) {
        super(blockProperties);
        setRegistryName(getResourceLocation(registryName));
        MOD_BLOCKS.add(this);
        MOD_ITEMS.add(new BlockItem(this, itemProperties).setRegistryName(getResourceLocation(registryName)));
    }

    public ModBlock(final String registryName, final Item.Properties itemProperties, final Properties blockProperties) {
        this(registryName, blockProperties, itemProperties);
    }
}
