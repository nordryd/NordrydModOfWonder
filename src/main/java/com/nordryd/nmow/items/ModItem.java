package com.nordryd.nmow.items;

import static com.nordryd.nmow.NordrydModOfWonder.MODID;
import static com.nordryd.nmow.init.ModItems.MOD_ITEMS;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ModItem extends Item {
    public ModItem(final String registryName, final Properties properties) {
        super(properties);
        setRegistryName(new ResourceLocation(MODID, registryName));
        MOD_ITEMS.add(this);
    }
}
