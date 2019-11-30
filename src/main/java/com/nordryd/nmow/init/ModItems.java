package com.nordryd.nmow.init;

import java.util.ArrayList;
import java.util.List;

import com.nordryd.nmow.items.ModFood;
import com.nordryd.nmow.items.ModItem;
import com.nordryd.nmow.items.properties.FoodProperties;
import com.nordryd.nmow.items.properties.ItemProperties;
import net.minecraft.item.Item;

public interface ModItems {
    List<Item> MOD_ITEMS = new ArrayList<>();

    Item TEST_ITEM = new ModItem(new ItemProperties("test_item"));
    Item TEST_FOOD =
            new ModFood(new FoodProperties().makeWolfFood().amount(5).saturation(10f), new ItemProperties("test_food"));
}
