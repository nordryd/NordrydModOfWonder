package com.nordryd.nmow.items;

import static com.nordryd.nmow.NordrydModOfWonder.MODID;
import static com.nordryd.nmow.init.ModItems.MOD_ITEMS;

import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;

public class ModToolFactory {

    public static Item createModTool(final String registryName, final ModToolType toolType, final IItemTier material,
            final int attackDamage, final float attackSpeed, final Properties properties) {
        final Item item;
        switch (toolType) {
            case PICKAXE:
                item = new PickaxeItem(material, attackDamage, attackSpeed, properties);
                break;
            case SWORD:
                item = new SwordItem(material, attackDamage, attackSpeed, properties);
                break;
            case SHOVEL:
                item = new ShovelItem(material, attackDamage, attackSpeed, properties);
                break;
            case HOE:
                item = new HoeItem(material, attackSpeed, properties);
                break;
            case AXE:
                item = new AxeItem(material, attackDamage, attackSpeed, properties);
                break;
            default:
                throw new UnsupportedOperationException("Somehow a ToolType that does not exist (or null) was given...?");
        }
        MOD_ITEMS.add(item);
        return item.setRegistryName(MODID, registryName);
    }

    public enum ModToolType {
        PICKAXE,
        SWORD,
        SHOVEL,
        HOE,
        AXE
    }
}
