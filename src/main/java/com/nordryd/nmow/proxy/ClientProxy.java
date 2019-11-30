package com.nordryd.nmow.proxy;

import static com.nordryd.nmow.util.ModReference.MODID;
import static net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ClientProxy implements CommonProxy {
    @Override
    public void registerItemRenderer(final Item item, final int meta, final String id) {
        setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }

    @Override
    public void registerVariantRenderer(final Item item, final int meta, final String filename, final String id) {
        setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(MODID, filename), id));
    }
}
