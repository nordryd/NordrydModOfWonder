package com.nordryd.nmow.items.properties;

import static net.minecraft.inventory.EntityEquipmentSlot.LEGS;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class ArmorProperties {
    private final EntityEquipmentSlot equipmentSlot;
    private final int renderIndex;
    private final ArmorMaterial material;

    public ArmorProperties(final EntityEquipmentSlot equipmentSlot, final ArmorMaterial material) {
        this.equipmentSlot = equipmentSlot;
        this.renderIndex = (equipmentSlot == LEGS) ? 2 : 1;
        this.material = material;
    }

    public ArmorProperties(final ArmorMaterial material, final EntityEquipmentSlot equipmentSlot) {
        this(equipmentSlot, material);
    }

    public EntityEquipmentSlot equipmentSlot() {
        return equipmentSlot;
    }

    public int renderIndex() {
        return renderIndex;
    }

    public ArmorMaterial material() {
        return material;
    }
}
