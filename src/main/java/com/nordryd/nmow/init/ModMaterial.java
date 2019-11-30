package com.nordryd.nmow.init;

import static com.nordryd.nmow.util.ModReference.MODID;
import static net.minecraft.item.ItemArmor.ArmorMaterial;
import static net.minecraftforge.common.util.EnumHelper.addArmorMaterial;
import static net.minecraftforge.common.util.EnumHelper.addToolMaterial;

import com.nordryd.nmow.util.values.HarvestLevel;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;

public interface ModMaterial {
    ToolMaterial MATERIAL_TEST = addToolMaterial("material_test", HarvestLevel.TEST.getLevel(), 6969, 8f, 69f, 69);

    ArmorMaterial TEST_ARMOR_MATERIAL =
            addArmorMaterial("armor_material_test", (MODID + ":test"), 14, new int[] {69, (69 * 3), (69 * 5), (69 * 2)}, 69,
                    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 69F);
}
