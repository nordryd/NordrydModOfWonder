package com.nordryd.nmow.block;

import static com.nordryd.nmow.Main.proxy;
import static com.nordryd.nmow.init.ModBlocks.MOD_BLOCKS;
import static com.nordryd.nmow.init.ModCreativeTabs.MASTER;
import static com.nordryd.nmow.init.ModItems.MOD_ITEMS;
import static net.minecraft.item.Item.getItemFromBlock;

import com.nordryd.nmow.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public class ModBlock extends Block implements IHasModel {
//    private ModBlock(final Builder builder){
//        super(builder.material);
//    }

    public ModBlock(final String name, final Material material, final CreativeTabs creativeTab) {
        super(material);

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(creativeTab);

        MOD_BLOCKS.add(this);
        MOD_ITEMS.add(new ItemBlock(this).setRegistryName(getRegistryName()));
    }

    public ModBlock(final String name, final Material material) {
        this(name, material, MASTER);
    }

    @Override
    public void registerModels() {
        proxy.registerItemRenderer(getItemFromBlock(this), 0, "inventory");
    }

    public static final class Builder{

    }
}
