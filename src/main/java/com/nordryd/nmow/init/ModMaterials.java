package com.nordryd.nmow.init;

import static com.nordryd.nmow.init.ModItems.test_item;
import static com.nordryd.nmow.util.enums.HarvestLevel.DIAMOND;
import static net.minecraft.item.crafting.Ingredient.fromItems;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ModMaterials implements IItemTier {
    TEST_TOOL_MATERIAL(69f, 69f, 69 * 2, DIAMOND.getLevel(), 69, test_item);

    private final float attackDamage, efficiency;
    private final int maxUses, harvestLevel, enchantability;
    private Item repairMaterial;

    ModMaterials(final float attackDamage, final float efficiency, final int maxUses, final int harvestLevel,
            final int enchantability, final Item repairMaterial) {
        this.attackDamage = attackDamage;
        this.efficiency = efficiency;
        this.maxUses = maxUses;
        this.harvestLevel = harvestLevel;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return fromItems(repairMaterial);
    }
}
