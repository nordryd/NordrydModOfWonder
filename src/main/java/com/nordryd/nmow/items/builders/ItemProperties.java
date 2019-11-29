package com.nordryd.nmow.items.builders;

import com.nordryd.nmow.init.ModCreativeTabs;
import net.minecraft.creativetab.CreativeTabs;

public class ItemProperties {
    private final String name;
    private CreativeTabs creativeTab;

    public ItemProperties(final String name) {
        this.name = name;
        this.creativeTab = ModCreativeTabs.MASTER;
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
