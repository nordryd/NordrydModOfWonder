package com.nordryd.nmow.init;

import java.util.ArrayList;
import java.util.List;

import com.nordryd.nmow.items.ModItem;

import net.minecraft.item.Item;

public interface ModItems {
	List<Item> MOD_ITEMS = new ArrayList<>();
	
	Item TEST_ITEM = new ModItem("test_item");
}
