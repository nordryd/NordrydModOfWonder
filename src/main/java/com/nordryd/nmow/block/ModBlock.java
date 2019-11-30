package com.nordryd.nmow.block;

import static com.nordryd.nmow.Main.proxy;
import static com.nordryd.nmow.init.ModBlocks.MOD_BLOCKS;
import static com.nordryd.nmow.init.ModItems.MOD_ITEMS;
import static net.minecraft.item.Item.getItemFromBlock;

import com.nordryd.nmow.block.properties.BlockProperties;
import com.nordryd.nmow.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ModBlock extends Block implements IHasModel {
    public ModBlock(final BlockProperties blockProperties) {
        super(blockProperties.material());
        setUnlocalizedName(blockProperties.name());
        setRegistryName(blockProperties.name());
        setCreativeTab(blockProperties.creativeTab());
        setSoundType(blockProperties.soundType());
        setHarvestLevel(blockProperties.toolTypeRequired().getStringId(),
                blockProperties.toolMaterialRequired().getLevel());

        if (blockProperties.hardness() != null) {
            setHardness(blockProperties.hardness());
        }

        if (blockProperties.resistance() != null) {
            setResistance(blockProperties.resistance());
        }

        if (blockProperties.lightLevel() != null) {
            setLightLevel(blockProperties.lightLevel());
        }

        if (blockProperties.lightOpacity() != null) {
            setLightOpacity(blockProperties.lightOpacity());
        }

        if (blockProperties.isUnbreakable()) {
            setBlockUnbreakable();
        }

        MOD_BLOCKS.add(this);
        MOD_ITEMS.add(new ItemBlock(this).setRegistryName(getRegistryName()));
    }

    @Override
    public void registerModels() {
        proxy.registerItemRenderer(getItemFromBlock(this), 0, "inventory");
    }
}
