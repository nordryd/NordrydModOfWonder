package com.nordryd.nmow.init;

import static com.nordryd.nmow.init.ModItems.test_item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public interface ModItemGroups {
    ItemGroup MASTER = new ItemGroup("master") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(test_item);
        }
    };
}
