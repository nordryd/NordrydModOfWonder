package com.nordryd.nmow.items;

import static com.nordryd.nmow.Main.proxy;
import static com.nordryd.nmow.init.ModItems.MOD_ITEMS;

import com.nordryd.nmow.items.properties.ArmorProperties;
import com.nordryd.nmow.items.properties.ItemProperties;
import com.nordryd.nmow.util.IHasModel;
import net.minecraft.item.ItemArmor;

public class ModArmor extends ItemArmor implements IHasModel {
    public ModArmor(final ItemProperties itemProperties, final ArmorProperties armorProperties) {
        super(armorProperties.material(), armorProperties.renderIndex(), armorProperties.equipmentSlot());
        setUnlocalizedName(itemProperties.name());
        setRegistryName(itemProperties.name());
        setCreativeTab(itemProperties.creativeTab());
        MOD_ITEMS.add(this);
    }

    public ModArmor(final ArmorProperties armorProperties, final ItemProperties itemProperties) {
        this(itemProperties, armorProperties);
    }

    @Override
    public void registerModels() {
        proxy.registerItemRenderer(this, 0, "inventory");
    }
}
