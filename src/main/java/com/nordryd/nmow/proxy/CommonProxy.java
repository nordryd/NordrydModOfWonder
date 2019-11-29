package com.nordryd.nmow.proxy;

import net.minecraft.item.Item;

public interface CommonProxy {
	void registerItemRenderer(final Item item, final int meta, final String id);
	void registerVariantRenderer(final Item item, final int meta, final String filename, final String id);
}
