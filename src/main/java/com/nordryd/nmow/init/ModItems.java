package com.nordryd.nmow.init;

import static com.nordryd.nmow.init.ModItemGroups.MASTER;
import static com.nordryd.nmow.init.ModMaterials.TEST_TOOL_MATERIAL;
import static com.nordryd.nmow.items.ModToolFactory.ModToolType.AXE;
import static com.nordryd.nmow.items.ModToolFactory.ModToolType.HOE;
import static com.nordryd.nmow.items.ModToolFactory.ModToolType.PICKAXE;
import static com.nordryd.nmow.items.ModToolFactory.ModToolType.SHOVEL;
import static com.nordryd.nmow.items.ModToolFactory.ModToolType.SWORD;
import static com.nordryd.nmow.items.ModToolFactory.createModTool;

import java.util.ArrayList;
import java.util.List;

import com.nordryd.nmow.items.ModItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;

public interface ModItems {
    List<Item> MOD_ITEMS = new ArrayList<>();

    Item test_item = new ModItem("test_item", new Properties().group(MASTER));
    Item test_pickaxe =
            createModTool("test_pickaxe", PICKAXE, TEST_TOOL_MATERIAL, 69, 69f, new Item.Properties().group(MASTER));
    Item test_sword = createModTool("test_sword", SWORD, TEST_TOOL_MATERIAL, 69, 69f, new Item.Properties().group(MASTER));
    Item test_shovel =
            createModTool("test_shovel", SHOVEL, TEST_TOOL_MATERIAL, 69, 69f, new Item.Properties().group(MASTER));
    Item test_hoe = createModTool("test_hoe", HOE, TEST_TOOL_MATERIAL, 69, 69f, new Item.Properties().group(MASTER));
    Item test_axe = createModTool("test_axe", AXE, TEST_TOOL_MATERIAL, 69, 69f, new Item.Properties().group(MASTER));
}
