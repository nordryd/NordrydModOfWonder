package com.nordryd.nmow.init;

import static com.nordryd.nmow.init.ModItems.TEST_ITEM;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public interface ModCreativeTabs {
    CreativeTabs MASTER = new CreativeTabs("tab_master") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(TEST_ITEM);
        }
    };
}
