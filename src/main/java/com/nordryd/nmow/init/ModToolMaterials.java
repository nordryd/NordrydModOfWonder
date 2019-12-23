package com.nordryd.nmow.init;

import static com.nordryd.nmow.init.ModItems.test_item;
import static com.nordryd.nmow.util.enums.HarvestLevel.DIAMOND;
import static net.minecraft.item.crafting.Ingredient.fromItems;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ModToolMaterials implements IItemTier {
    TEST_TOOL_MATERIAL("test", 69f, 69f, 69 * 2, DIAMOND.getLevel(), 69, test_item, 69, 69f, 69, 69f, 69, 69f, 69, 69f, 69f);

    private final String name;
    private final float attackDamage, efficiency;
    private final int maxUses, harvestLevel, enchantability;
    private final Item repairMaterial;
    private final int pickaxeDmg, swordDmg, shovelDmg, axeDmg;
    private final float pickaxeSpeed, swordSpeed, shovelSpeed, axeSpeed, hoeSpeed;

    ModToolMaterials(final String name, final float attackDamage, final float efficiency, final int maxUses,
            final int harvestLevel, final int enchantability, final Item repairMaterial, final int pickaxeDmg,
            final float pickaxeSpeed, final int swordDmg, final float swordSpeed, final int shovelDmg,
            final float shovelSpeed, final int axeDmg, final float axeSpeed, final float hoeSpeed) {
        this.name = name;
        this.attackDamage = attackDamage;
        this.efficiency = efficiency;
        this.maxUses = maxUses;
        this.harvestLevel = harvestLevel;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
        this.pickaxeDmg = pickaxeDmg;
        this.swordDmg = swordDmg;
        this.shovelDmg = shovelDmg;
        this.axeDmg = axeDmg;
        this.pickaxeSpeed = pickaxeSpeed;
        this.swordSpeed = swordSpeed;
        this.shovelSpeed = shovelSpeed;
        this.axeSpeed = axeSpeed;
        this.hoeSpeed = hoeSpeed;
    }

    public String getName() {
        return name;
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

    public int getPickaxeDmg() {
        return pickaxeDmg;
    }

    public int getSwordDmg() {
        return swordDmg;
    }

    public int getShovelDmg() {
        return shovelDmg;
    }

    public int getAxeDmg() {
        return axeDmg;
    }

    public float getPickaxeSpeed() {
        return pickaxeSpeed;
    }

    public float getSwordSpeed() {
        return swordSpeed;
    }

    public float getShovelSpeed() {
        return shovelSpeed;
    }

    public float getAxeSpeed() {
        return axeSpeed;
    }

    public float getHoeSpeed() {
        return hoeSpeed;
    }
}
