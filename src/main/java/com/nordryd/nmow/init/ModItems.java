package com.nordryd.nmow.init;

import static com.nordryd.nmow.init.ModArmorMaterials.TEST_ARMOR_MATERIAL;
import static com.nordryd.nmow.init.ModItemGroups.MASTER;
import static com.nordryd.nmow.init.ModToolMaterials.TEST_TOOL_MATERIAL;
import static com.nordryd.nmow.items.ModArmorFactory.createArmorSet;
import static com.nordryd.nmow.items.ModToolFactory.createToolSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nordryd.nmow.items.ModItem;
import com.nordryd.nmow.util.enums.ModToolType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;

public interface ModItems {
    List<Item> MOD_ITEMS = new ArrayList<>();

    Item test_item = new ModItem("test_item", new Properties().group(MASTER));

    Map<ModToolType, Item> test_tool_set = createToolSet(TEST_TOOL_MATERIAL, new Properties().group(MASTER));
    Map<EquipmentSlotType, Item> test_armor_set = createArmorSet(TEST_ARMOR_MATERIAL, new Properties().group(MASTER));
}
