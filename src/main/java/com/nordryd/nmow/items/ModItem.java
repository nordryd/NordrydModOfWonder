package com.nordryd.nmow.items;

import static com.nordryd.nmow.Main.proxy;
import static com.nordryd.nmow.init.ModCreativeTabs.MASTER;
import static com.nordryd.nmow.init.ModItems.MOD_ITEMS;

import com.nordryd.nmow.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModItem extends Item implements IHasModel {
    public ModItem(final String name, final CreativeTabs creativeTab) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(creativeTab);
        MOD_ITEMS.add(this);
    }

    public ModItem(final String name) {
        this(name, MASTER);
    }

    @Override
    public void registerModels() {
        proxy.registerItemRenderer(this, 0, "inventory");
    }
}
