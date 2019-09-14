package com.nordryd.nmow.items;

import com.nordryd.nmow.Main;
import com.nordryd.nmow.init.ModItems;
import com.nordryd.nmow.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModItem extends Item implements IHasModel {
	public ModItem(String name) {

		// Sets the item's name with "item" prepended.
		setUnlocalizedName(name);

		// Sets name in the registry
		setRegistryName(name);

		// Sets item to go into the MATERIALS tab of creative mode
		setCreativeTab(CreativeTabs.MISC);

		// Tell minecraft that this [object] is an item
		ModItems.MOD_ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
