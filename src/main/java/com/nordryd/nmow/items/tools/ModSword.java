package com.nordryd.nmow.items.tools;

import static com.nordryd.nmow.Main.proxy;
import static com.nordryd.nmow.init.ModItems.MOD_ITEMS;

import com.nordryd.nmow.items.properties.ItemProperties;
import com.nordryd.nmow.util.IHasModel;
import net.minecraft.item.ItemSword;

public class ModSword extends ItemSword implements IHasModel {

    public ModSword(final ItemProperties itemProperties, final ToolMaterial material) {
        super(material);
        setUnlocalizedName(itemProperties.name());
        setRegistryName(itemProperties.name());
        setCreativeTab(itemProperties.creativeTab());
        MOD_ITEMS.add(this);
    }

    public ModSword(final ToolMaterial material, final ItemProperties itemProperties) {
        this(itemProperties, material);
    }

    @Override
    public void registerModels() {
        proxy.registerItemRenderer(this, 0, "inventory");
    }
}
