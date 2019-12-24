package com.nordryd.nmow.items;

import static com.nordryd.nmow.init.ModItems.MOD_ITEMS;
import static net.minecraft.inventory.EquipmentSlotType.CHEST;
import static net.minecraft.inventory.EquipmentSlotType.FEET;
import static net.minecraft.inventory.EquipmentSlotType.HEAD;
import static net.minecraft.inventory.EquipmentSlotType.LEGS;

import java.util.EnumMap;
import java.util.Map;

import com.nordryd.nmow.init.ModArmorMaterials;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class ModArmorFactory {
    public static Map<EquipmentSlotType, Item> createArmorSet(final ModArmorMaterials armorMaterial,
            final Item.Properties properties) {
        final Map<EquipmentSlotType, Item> armorSet = new EnumMap<>(EquipmentSlotType.class);
        armorSet.put(HEAD,
                new ArmorItem(armorMaterial, HEAD, properties).setRegistryName(armorMaterial.getName() + "_helmet"));
        armorSet.put(CHEST,
                new ArmorItem(armorMaterial, CHEST, properties).setRegistryName(armorMaterial.getName() + "_chestplate"));
        armorSet.put(LEGS,
                new ArmorItem(armorMaterial, LEGS, properties).setRegistryName(armorMaterial.getName() + "_leggings"));
        armorSet.put(FEET,
                new ArmorItem(armorMaterial, FEET, properties).setRegistryName(armorMaterial.getName() + "_boots"));

        MOD_ITEMS.addAll(armorSet.values());
        return armorSet;
    }
}
