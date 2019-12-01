package com.nordryd.nmow.init;

import static com.nordryd.nmow.init.ModBlocks.TEST_ORE;
import static com.nordryd.nmow.init.ModItems.TEST_FOOD;
import static com.nordryd.nmow.init.ModItems.TEST_ITEM;
import static net.minecraftforge.fml.common.registry.GameRegistry.addSmelting;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public interface ModRecipes {
    static void initSmeltingRecipes() {
        addSmelting(TEST_ITEM, new ItemStack(TEST_FOOD, 1), 1.5f);
        addSmelting(TEST_ORE, new ItemStack(TEST_ITEM, 1), 1.5f);
    }
}
