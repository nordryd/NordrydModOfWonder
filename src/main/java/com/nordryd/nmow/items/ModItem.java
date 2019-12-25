package com.nordryd.nmow.items;

import static com.nordryd.nmow.util.ModUtility.getResourceLocation;
import static com.nordryd.nmow.init.ModItems.MOD_ITEMS;

import net.minecraft.item.Item;

public class ModItem extends Item {
    public ModItem(final String registryName, final Properties properties) {
        super(properties);
        setRegistryName(getResourceLocation(registryName));
        MOD_ITEMS.add(this);
    }
}
