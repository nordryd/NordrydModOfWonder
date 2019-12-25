package com.nordryd.nmow.init;

import static com.nordryd.nmow.NordrydModOfWonder.MODID;
import static net.minecraft.item.crafting.Ingredient.fromItems;
import static net.minecraft.util.SoundEvents.AMBIENT_CAVE;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;

public enum ModArmorMaterials implements IArmorMaterial {
    TEST_ARMOR_MATERIAL("test", 500, 69, ModItems.test_item, AMBIENT_CAVE, 0f, 69 * 2, 69 * 4, 69 * 3, 69);

    private static final int[] MAX_DMG_ARRAY = new int[] {13, 15, 16, 11};

    private final String name;
    private final SoundEvent equipSound;
    private final int durability, enchantability;
    private final float toughness;
    private final Item repairItem;
    private final int[] damageReductionAmounts;

    ModArmorMaterials(final String name, final int durability, final int enchantability, final Item repairItem,
            final SoundEvent equipSound, final float toughness, final int headReduction, final int chestReduction,
            final int legReduction, final int feetReduction) {
        this.name = name;
        this.equipSound = equipSound;
        this.enchantability = enchantability;
        this.repairItem = repairItem;
        this.toughness = toughness;
        this.durability = durability;
        this.damageReductionAmounts = new int[] {headReduction, chestReduction, legReduction, feetReduction};
    }


    @Override
    public int getDurability(final EquipmentSlotType slotIn) {
        return MAX_DMG_ARRAY[slotIn.getIndex()] * durability;
    }

    @Override
    public int getDamageReductionAmount(final EquipmentSlotType slotIn) {
        return damageReductionAmounts[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return equipSound;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return fromItems(repairItem);
    }

    @Override
    public String getName() {
        return MODID + ":" + name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }
}
