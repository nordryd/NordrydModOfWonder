package com.nordryd.nmow.items;

import static com.nordryd.nmow.util.ModUtility.getResourceLocation;
import static com.nordryd.nmow.init.ModItems.MOD_ITEMS;
import static com.nordryd.nmow.util.enums.ModToolType.AXE;
import static com.nordryd.nmow.util.enums.ModToolType.HOE;
import static com.nordryd.nmow.util.enums.ModToolType.PICKAXE;
import static com.nordryd.nmow.util.enums.ModToolType.SHOVEL;
import static com.nordryd.nmow.util.enums.ModToolType.SWORD;

import java.util.EnumMap;
import java.util.Map;

import com.nordryd.nmow.init.ModToolMaterials;
import com.nordryd.nmow.util.enums.ModToolType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;

public class ModToolFactory {

    public static Map<ModToolType, Item> createToolSet(final ModToolMaterials material, final Properties properties) {
        final Map<ModToolType, Item> toolSet = new EnumMap<>(ModToolType.class);

        toolSet.put(PICKAXE, new PickaxeItem(material, material.getPickaxeDmg(), material.getPickaxeSpeed(), properties)
                .setRegistryName(getResourceLocation(material.getName() + "_pickaxe")));
        toolSet.put(SWORD, new SwordItem(material, material.getSwordDmg(), material.getSwordSpeed(), properties)
                .setRegistryName(getResourceLocation(material.getName() + "_sword")));
        toolSet.put(SHOVEL, new ShovelItem(material, material.getShovelDmg(), material.getShovelSpeed(), properties)
                .setRegistryName(getResourceLocation(material.getName() + "_shovel")));
        toolSet.put(AXE, new AxeItem(material, material.getAxeDmg(), material.getAxeSpeed(), properties)
                .setRegistryName(getResourceLocation(material.getName() + "_axe")));
        toolSet.put(HOE, new HoeItem(material, material.getHoeSpeed(), properties)
                .setRegistryName(getResourceLocation(material.getName() + "_hoe")));

        MOD_ITEMS.addAll(toolSet.values());
        return toolSet;
    }
}
