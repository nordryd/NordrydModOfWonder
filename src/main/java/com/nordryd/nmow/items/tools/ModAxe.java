package com.nordryd.nmow.items.tools;

import static com.nordryd.nmow.Main.proxy;
import static com.nordryd.nmow.init.ModItems.MOD_ITEMS;

import com.nordryd.nmow.items.properties.ItemProperties;
import com.nordryd.nmow.util.IHasModel;
import net.minecraft.item.ItemAxe;

public class ModAxe extends ItemAxe implements IHasModel {

    public ModAxe(final ItemProperties itemProperties, final ToolMaterial material, final float attackDamage,
            final float attackSpeed) {
        super(material, attackDamage, attackSpeed);
        setUnlocalizedName(itemProperties.name());
        setRegistryName(itemProperties.name());
        setCreativeTab(itemProperties.creativeTab());
        MOD_ITEMS.add(this);
    }

    public ModAxe(final ItemProperties itemProperties, final ToolMaterial material) {
        this(itemProperties, material, material.getAttackDamage(), 1.0f);
    }

    public ModAxe(final ToolMaterial material, final ItemProperties itemProperties) {
        this(itemProperties, material, material.getAttackDamage(), 1.0f);
    }

    @Override
    public void registerModels() {
        proxy.registerItemRenderer(this, 0, "inventory");
    }
}
