package com.nordryd.nmow.items;

import static com.nordryd.nmow.Main.proxy;
import static com.nordryd.nmow.init.ModItems.MOD_ITEMS;

import com.nordryd.nmow.items.properties.FoodProperties;
import com.nordryd.nmow.items.properties.ItemProperties;
import com.nordryd.nmow.util.IHasModel;
import net.minecraft.item.ItemFood;

public class ModFood extends ItemFood implements IHasModel {

    public ModFood(final ItemProperties itemProperties, final FoodProperties foodProperties) {
        super(foodProperties.amount(), foodProperties.saturation(), foodProperties.isWolfFood());

        setUnlocalizedName(itemProperties.name());
        setRegistryName(itemProperties.name());
        setCreativeTab(itemProperties.creativeTab());

        MOD_ITEMS.add(this);
    }

    public ModFood(final FoodProperties foodProperties, final ItemProperties itemProperties){
        this(itemProperties, foodProperties);
    }

    @Override
    public void registerModels() {
        proxy.registerItemRenderer(this, 0, "inventory");
    }
}
