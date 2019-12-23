package com.nordryd.nmow.init;

import static com.nordryd.nmow.init.ModItemGroups.MASTER;

import java.util.ArrayList;
import java.util.List;

import com.nordryd.nmow.item.ModItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;

public interface ModItems {
    List<Item> MOD_ITEMS = new ArrayList<>();

    Item test_item = new ModItem("test_item", new Properties().group(MASTER));
}
