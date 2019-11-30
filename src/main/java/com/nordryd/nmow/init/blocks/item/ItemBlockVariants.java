package com.nordryd.nmow.init.blocks.item;

import com.nordryd.nmow.util.IMetaName;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * This class used when being added to MOD_ITEMS is what causes the other variant textures to appear!
 */
public class ItemBlockVariants extends ItemBlock {

    public ItemBlockVariants(final Block block) {
        super(block);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public String getUnlocalizedName(final ItemStack stack) {
        return super.getUnlocalizedName() + "_" + ((IMetaName)block).getSpecialName(stack);
    }

    @Override
    public int getMetadata(final int damage) {
        return damage;
    }
}
