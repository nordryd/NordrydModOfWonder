package com.nordryd.nmow.init;

import static com.nordryd.nmow.init.ModMaterial.MATERIAL_TEST;
import static com.nordryd.nmow.init.ModMaterial.TEST_ARMOR_MATERIAL;
import static net.minecraft.inventory.EntityEquipmentSlot.CHEST;
import static net.minecraft.inventory.EntityEquipmentSlot.FEET;
import static net.minecraft.inventory.EntityEquipmentSlot.HEAD;
import static net.minecraft.inventory.EntityEquipmentSlot.LEGS;

import java.util.ArrayList;
import java.util.List;

import com.nordryd.nmow.items.ModArmor;
import com.nordryd.nmow.items.ModFood;
import com.nordryd.nmow.items.ModItem;
import com.nordryd.nmow.items.properties.ArmorProperties;
import com.nordryd.nmow.items.properties.FoodProperties;
import com.nordryd.nmow.items.properties.ItemProperties;
import com.nordryd.nmow.items.tools.ModAxe;
import com.nordryd.nmow.items.tools.ModHoe;
import com.nordryd.nmow.items.tools.ModPickaxe;
import com.nordryd.nmow.items.tools.ModShovel;
import com.nordryd.nmow.items.tools.ModSword;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;

public interface ModItems {

    List<Item> MOD_ITEMS = new ArrayList<>();

    Item TEST_ITEM = new ModItem(new ItemProperties("test_item"));
    Item TEST_FOOD =
            new ModFood(new FoodProperties().makeWolfFood().amount(5).saturation(10f), new ItemProperties("test_food"));

    Item TEST_HELMET = new ModArmor(new ItemProperties("test_helmet"), new ArmorProperties(HEAD, TEST_ARMOR_MATERIAL));
    Item TEST_CHESTPLATE =
            new ModArmor(new ItemProperties("test_chestplate"), new ArmorProperties(CHEST, TEST_ARMOR_MATERIAL));
    Item TEST_LEGGINGS = new ModArmor(new ItemProperties("test_leggings"), new ArmorProperties(LEGS, TEST_ARMOR_MATERIAL));
    Item TEST_BOOTS = new ModArmor(new ItemProperties("test_boots"), new ArmorProperties(FEET, TEST_ARMOR_MATERIAL));

    ItemPickaxe TEST_PICKAXE = new ModPickaxe(new ItemProperties("test_pickaxe"), MATERIAL_TEST);
    ItemSword TEST_SWORD = new ModSword(new ItemProperties("test_sword"), MATERIAL_TEST);
    ItemAxe TEST_AXE = new ModAxe(new ItemProperties("test_axe"), MATERIAL_TEST);
    ItemHoe TEST_HOE = new ModHoe(new ItemProperties("test_hoe"), MATERIAL_TEST);
    ItemSpade TEST_SHOVEL = new ModShovel(new ItemProperties("test_shovel"), MATERIAL_TEST);
}
