package com.nordryd.nmow.items.properties;

import com.nordryd.nmow.init.ModCreativeTabs;
import net.minecraft.creativetab.CreativeTabs;

public class ItemProperties {
    private final String name;
    private CreativeTabs creativeTab = ModCreativeTabs.MASTER;

    public ItemProperties(final String name) {
        this.name = name;
    }

    public String name(){
        return name;
    }

    public CreativeTabs creativeTab() {
        return creativeTab;
    }

    public ItemProperties creativeTab(final CreativeTabs creativeTab) {
        this.creativeTab = creativeTab;
        return this;
    }
}
